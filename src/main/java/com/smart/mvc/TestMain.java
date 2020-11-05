package com.smart.mvc;

/**
 * 国内 域名注册
 * 文件上传
 * 1> 普通的文件上传
 * 2>上传到 OSS云对象存储  阿里 腾讯 七牛
 * 3> FastDFS 开发的成本比较高
 */
public class TestMain {
    public static void main(String[] args) {
        String img = "aa.aa.jpg";
        String suffixName = img.substring(img.lastIndexOf("."));
        System.out.println(suffixName);
    }

}
