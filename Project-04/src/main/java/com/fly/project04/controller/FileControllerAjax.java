package com.fly.project04.controller;

import com.fly.project04.utils.JsonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RequestMapping( "/file" )
@RestController
public class FileControllerAjax {

    @Value( "${file.upload.dir}" )
    private String uploadPath;

    /**
     * 上传图片
     *
     * @param req  请求
     * @param file 接收上传的文件
     * @return
     */
// @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @PostMapping( "/uploadImg" )
    public JsonResult uploadImg(HttpServletRequest req, @RequestParam( "file" ) MultipartFile file) throws
            Exception {
        String originalFilename = file.getOriginalFilename();
        // 根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
        String fileName = System.currentTimeMillis() + file.getOriginalFilename();
        // 通过 req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
        String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator +
                fileName;
//        String newFileName = String.valueOf(new SimpleDateFormat(System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."))));

        // 第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录
        File destFile = new File(destFileName);
        destFile.getParentFile().mkdirs();
        // 把浏览器上传的文件复制到希望的位置
        file.transferTo(destFile);
        return JsonResult.success().data("filename", fileName);
    }
}
