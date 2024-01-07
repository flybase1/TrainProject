package com.example.demo;

import com.example.demo.entity.Student;
import com.example.demo.utils.ImageUtils;
import com.example.demo.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping( "/api" )
public class ImageController {

    @Autowired
    private ImageUtils imageUtils;

    @PostMapping( "/image/upload" )
    public JsonResult uploadImage(@RequestParam( value = "file", required = false ) MultipartFile[] multipartFile) {
        if (ObjectUtils.isEmpty(multipartFile)) {
            return JsonResult.fail().data("data", "请选择文件");
        }
        Map<String, List<String>> uploadImagesUrl = imageUtils.uploadImages(multipartFile);
        return JsonResult.success().data("data", uploadImagesUrl);
    }


    @PostMapping( "/image/upload/student" )
    public JsonResult uploadStudentImage(@RequestParam( value = "file", required = false ) MultipartFile[] multipartFile, Student student) {
        if (ObjectUtils.isEmpty(multipartFile)) {
            return JsonResult.fail().data("data", "请选择文件");
        }
        Map<String, List<String>> uploadImagesUrl = imageUtils.uploadImages(multipartFile);
        student.setUrl(uploadImagesUrl.get("imageUrl").get(0));
        return JsonResult.success().data("data", student);
        //return JsonResult.success().data("data", uploadImagesUrl);
    }
}