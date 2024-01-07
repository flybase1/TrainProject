package com.fly.project04.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping( "/img" )
@Slf4j
public class FileController {
    @Value( "${file.upload.dir}" )
    private String uploadPath;

    @PostMapping( "/uploadFile" )
    // 定义：接收文件对象 MultipartFile file变量名要与form表单中input type="file" 标签name属性名一致
    public String uploadByJarDeploy(@RequestParam( "file" ) MultipartFile file, Model model) {
        try {
            // 文件名
            String originalFilename = file.getOriginalFilename();
            log.info("文件名: {}", file.getOriginalFilename());
            log.info("文件大小: {}", file.getSize());
            log.info("文件类型: {}", file.getContentType());
            log.info("文件后缀名: {}", originalFilename.substring(originalFilename.lastIndexOf(".")));
            // 改文件名
            String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS-").format(new Date()) + UUID.randomUUID() + ext;
            log.info("新文件名称{}", newFileName);
            // 上传目录
//            File destFile = new File(uploadPath, newFileName);
//            // 目录不存在
//            if (!destFile.exists()) {
//                destFile.getParentFile().mkdirs();
//            }
//            // 上传文件
//            file.transferTo(destFile);
            file.transferTo(new File(uploadPath, newFileName));
            model.addAttribute("fileName", newFileName);
        } catch (Exception e) {
            return "上传失败" + e;
        }
        return "picture";
    }


    @GetMapping( "/back" )
    public String showPicture() {
        return "index";
    }


    @PostMapping( value = "/uploadImg" )
    public String uploadImg(HttpServletRequest req, @RequestParam( "file" ) MultipartFile file, Model m) {
        try {
            // 根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            // 通过 req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            log.info("服务器地址{}", req.getServletContext().getRealPath(""));
            String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;
            // 第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            // 把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            // 把文件名放在 model 里，以便后续显示用
            m.addAttribute("fileName", fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败，" + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败，" + e.getMessage();
        }
        return "picture";
    }

    @PostMapping( "/uploadMoreFile" )
    public String uploadFile(@RequestParam( "files" ) MultipartFile[] files) {
        // 存储上传成功的文件名，响应给客户端
        List<String> list = new ArrayList<>();
        // 判断文件数组长度
//        if (files.length <= 0) {
//            list.add("请选择文件");
//            return list;
//        }
        for (MultipartFile file : files) {
            // 源文件名
            String originalFilename = file.getOriginalFilename();
            // 文件格式
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 新文件名，避免文件名重复，造成文件替换问题
            String fileName = UUID.randomUUID() + "." + suffix;
            // 文件存储路径

            // 文件全路径
            File targetFile = new File(uploadPath + fileName);

            // 判断文件存储目录是否存在，不存在则新建目录
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdir();
            }
            try {
                // 将图片保存
                file.transferTo(targetFile);
                list.add(originalFilename);
            } catch (IOException e) {
                log.info("文件上传异常={}", e);
            }
        }
        return "redirect:/";
    }

}
