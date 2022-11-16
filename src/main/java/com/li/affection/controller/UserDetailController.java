package com.li.affection.controller;

import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.*;
import com.li.affection.service.*;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @Autowired
    private HeartWordService heartWordService;
    @Autowired
    private WorkLifeService workLifeService;
    @Autowired
    private DetailInformationService detailInformationService;
    @Autowired
    private HobbyService hobbyService;

    //基本资料===========================================================================================================
    @GetMapping("/listUserDetails")
    public ResponseResult listUserDetail() {
        return userDetailService.listUserDetails();
    }

    @GetMapping("/getUserDetail")
    public ResponseResult getUserDetail() {
        return userDetailService.selectUserDetail();
    }

    @PostMapping("/updateUserDetail")
    public ResponseResult updateUserDetail(@RequestBody UserDetail userDetail) {
        return userDetailService.updateUserDetail(userDetail);
    }

    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        String extension = "." + FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + UUID.randomUUID().toString()
                .replace("-", "") + extension;
        String path = "D:\\img";
        String dateDirPath = path + "/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File dateDir = new File(dateDirPath);
        if (!dateDir.exists()) {
            dateDir.mkdirs();
        }
        file.transferTo(new File(dateDir, newFileName));
        return "fail";
    }
    //==================================================================================================================

    //内心话=============================================================================================================
    @GetMapping("/getHeartWord")
    public ResponseResult getHeartWord() {
        return heartWordService.getHeartWord();
    }

    @PostMapping("/updateHeartWord")
    public ResponseResult updateHeartWord(@RequestBody HeartWord heartWord) {
        return heartWordService.updateHeartWord(heartWord);
    }
    //==================================================================================================================

    //工作和生活==========================================================================================================
    @GetMapping("/getWorkLife")
    public ResponseResult getWorkLife() {
        return workLifeService.getWorkLife();
    }

    @PostMapping("/updateWorkLife")
    public ResponseResult updateWorkLife(@RequestBody WorkLife workLife) {
        return workLifeService.updateWorkLife(workLife);
    }
    //==================================================================================================================

    //用户详细信息========================================================================================================
    @GetMapping("/getDetailInformation")
    public ResponseResult getDetailInformation() {
        return detailInformationService.getDetailInformation();
    }

    @PostMapping("/updateDetailInformation")
    public ResponseResult updateDetailInformation(@RequestBody DetailInformation detailInformation) {
        return detailInformationService.updateDetailInformation(detailInformation);
    }
    //==================================================================================================================

    //爱好兴趣============================================================================================================
    @GetMapping("/getHobby")
    public ResponseResult getHobby() {
        return hobbyService.getHobby();
    }

    @PostMapping("/updateHobby")
    public ResponseResult updateHobby(@RequestBody Hobby hobby) {
        return hobbyService.updateHobby(hobby);
    }
    //==================================================================================================================
}
