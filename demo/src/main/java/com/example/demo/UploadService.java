package com.example.demo;

import com.example.demo.utils.JsonResult;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
    String uploadImg(MultipartFile img);
}