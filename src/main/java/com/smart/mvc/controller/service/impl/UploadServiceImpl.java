package com.smart.mvc.controller.service.impl;

import com.smart.mvc.controller.service.UploadService;
import com.smart.mvc.utils.UploadFileUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 */
@Service
public class UploadServiceImpl implements UploadService {

    @Override
    public String uploadImage(MultipartFile multipartFile) throws IOException {
        return UploadFileUtils.saveImage(multipartFile);
    }
}
