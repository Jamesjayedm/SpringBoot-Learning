package com.james.springbootdata.controller;

import com.james.springbootdata.ret.RetResponse;
import com.james.springbootdata.ret.RetResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * 文件上传demo
 */
@RestController
public class UploadController {

    @RequestMapping("/uploadFile")
    public RetResult<String> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        if (file == null) {
            throw new Exception("文件不能为空");
        } else {
            String fileName = file.getOriginalFilename();
            System.out.println(fileName);
            String path = getClass().getResource("/").getPath();
            System.out.println(path);
            try {
                file.transferTo(new File(path + fileName));
                return RetResponse.makeOKRsp("上传成功");
            } catch (Exception e) {
                e.printStackTrace();
                return RetResponse.makeErrRsp();
            }
        }


    }
}
