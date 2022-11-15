package com.li.affection.controller;

import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.UserDetail;
import com.li.affection.service.UserDetailService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class UserDetailController {
    @Autowired
    private UserDetailService userDetailService;
    @GetMapping("/listUserDetails")
    public ResponseResult listUserDetail(){
        return userDetailService.listUserDetails();
    }
    @GetMapping("/getUserDetail")
    public ResponseResult getUserDetail(){
        return userDetailService.selectUserDetail();
    }
    @PostMapping("/updateUserDetail")
    public ResponseResult updateUserDetail(@RequestBody UserDetail userDetail){
        return userDetailService.updateUserDetail(userDetail);
    }
    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        String extension = "."+ FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+ UUID.randomUUID().toString()
                .replace("-","")+extension;
        String path = "D:\\img";
        String dateDirPath = path+"/"+new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File dateDir = new File(dateDirPath);
        if (!dateDir.exists()) {
            dateDir.mkdirs();
        }
        file.transferTo(new File(dateDir,newFileName));
        return "fail";
    }
}
