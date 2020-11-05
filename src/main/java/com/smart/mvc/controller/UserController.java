package com.smart.mvc.controller;

import com.smart.mvc.controller.service.UploadService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@RestController
public class UserController {
    @Resource
    UploadService uploadService;

    /**
     * 存在的问题
     * 1. 文件覆盖的问题
     * 2>  对文件进行重命名
     * 3>  使用动态路径
     * 保存路径到数据库
     * /images/
     *
     * @param multipartFile
     * @return 前端
     * type=file  key= "file"
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("uid") int uid, @RequestParam("img") MultipartFile multipartFile) {
        String imagePath = null;
        try {
            imagePath = uploadService.uploadImage(multipartFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagePath;
    }
}
