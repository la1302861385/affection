package com.li.affection.controller;

import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.User;
import com.li.affection.service.LoginService;
import com.li.affection.service.ModifyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginUserController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private ModifyUserService modifyUserService;
    //用户登陆
    @RequestMapping("/loginUser")
    public ResponseResult loginUser(@RequestBody User user){
        return loginService.login(user);
    }

    //用户注销
    @PostMapping("/logoutUser")
    public ResponseResult logout(){
        return  loginService.logout();
    }

    //校验密码
    @PostMapping("/checkPassword")
    public ResponseResult checkPassword(@RequestParam(value = "password") String password){
        return modifyUserService.checkPassword(password);
    }

    //校验用户名是否重复
    @GetMapping("/checkUserName")
    public ResponseResult checkUserName(@RequestParam(value = "username") String username){
        return modifyUserService.checkUserName(username);
    }

    //修改密码
    @PostMapping("/updatePassword")
    public ResponseResult updatePassword(@RequestParam String password){
        return modifyUserService.updatePassword(password);
    }

    //注册用户
    @PostMapping("/regUser")
    public ResponseResult addUser(@RequestBody User user){
        return modifyUserService.addUser(user);
    }

    //验证token
    @GetMapping("/authToken")
    public ResponseResult authToken(){
        return new ResponseResult(200,"验证成功");
    }

}
