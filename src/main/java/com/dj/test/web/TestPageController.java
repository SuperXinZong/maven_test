package com.dj.test.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class TestPageController {

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "/index";
    }


    @RequestMapping("/upLoad")
    public String upLoad(MultipartFile img) {
        try {
            // 存起来（硬盘[文件路径]、数据库[ID]、七牛云[url]）
            System.out.println(img.getName());
            System.out.println(img.getOriginalFilename());// 文件的真实名
            System.out.println(img.getSize());// 文件的大小
            // 持久化
            img.transferTo(new File("e://"+ img.getOriginalFilename()));
            // 生成文件唯一标识
            // ...
//            // 文件流
//            OutputStream outputStream = new FileOutputStream("e://" + img.getOriginalFilename());
//            outputStream.write(img.getBytes());
//            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/index";
    }

    /**
     * 下载
     * @param fileName 文件标识
     */
    @RequestMapping("/download")
    public void downLoad(HttpServletResponse response, String fileName) {
        try {
            // 1、根据文件标识将文件读取到程序中
            InputStream inputStream = new FileInputStream("e://" + fileName);
            // available 流的大小
            byte[] bytes = new byte[inputStream.available()];
            // 读
            inputStream.read(bytes);
            // 2、将文件返回给用户
            response.setHeader("Content-Disposition","attachment;filename="+fileName);
            OutputStream outputStream = response.getOutputStream();
            // 写
            outputStream.write(bytes);
            inputStream.close();
//            OutputStream outputStream = new FileOutputStream("");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
