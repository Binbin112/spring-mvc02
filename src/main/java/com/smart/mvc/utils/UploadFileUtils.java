package com.smart.mvc.utils;


import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 处理控制层请求
 * linux系统 /home/smart/
 * D:\img
 */
public class UploadFileUtils {
    public static final String IMG_PREFIX = "IMG_";
    public static final String DATETIME_PATTERN = "yyyyMMddHHmmss";
    public static final String DATE_PATTERN = "yyyyMMdd";
    public static final String ROOT_PATH = "D:\\smart";
    private static final String IMAGE_PATH = "images";

    /**
     * 获取保存图片的路径
     *
     * @return
     */
    public static String saveImage(MultipartFile multipartFile) throws IOException {
        //返回给数据库保存的路径
        String imagePath = IMAGE_PATH + File.separator +
                DateFormatUtils.format(new Date(), DATE_PATTERN);
        // 保存图片的绝对路径
        File file = new File(ROOT_PATH + File.separator + imagePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        String imageName = getImageNewName(multipartFile.getOriginalFilename());
        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), new File(file, imageName));

        return imagePath + File.separator + imageName;
    }

    public static String getImageNewName(String oldName) {
        // img_时间戳_随机数.后缀
        //IMG_2020110416
        String format = DateFormatUtils.format(new Date(), DATETIME_PATTERN);
        return String.format("%s%s%s", IMG_PREFIX, format, getFileSuffixName(oldName));
    }


    /**
     * 获取文件的后缀名
     *
     * @param fileName
     * @return
     */
    public static String getFileSuffixName(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static void main(String[] args) {
        String imageNewName = getImageNewName("aaa.jpg");
        System.out.println(imageNewName);
        // IMG_20201104164807.jpg

    }
}
