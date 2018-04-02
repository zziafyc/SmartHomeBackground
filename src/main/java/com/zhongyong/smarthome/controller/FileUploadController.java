package com.zhongyong.smarthome.controller;

import com.zhongyong.smarthome.base.HttpResult;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@RequestMapping("upload")
@RestController
public class FileUploadController {

    @PostMapping("/uploadOneFile")
    @ResponseBody
    public HttpResult<Void> uploadOneFile(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return new HttpResult<>(100, "上传失败," + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
                return new HttpResult<>(100, "上传失败," + e.getMessage());
            }
            return new HttpResult<>(200, "上传成功");

        } else {
            return new HttpResult<>(101, "上传失败,文件是空的");
        }
    }

    @PostMapping("/uploadMultiFile")
    @ResponseBody
    public HttpResult<Void> uploadMultiFile(HttpServletRequest request) {
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        String name = params.getParameter("name");
        System.out.println("name:" + name);
        String id = params.getParameter("id");
        System.out.println("id:" + id);
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(new File(file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    return new HttpResult<>(100, "上传失败," + e.getMessage());
                }
            } else {
                return new HttpResult<>(101, "上传失败,文件是空的");
            }
        }
        return new HttpResult<>(200, "上传成功");
    }
}
