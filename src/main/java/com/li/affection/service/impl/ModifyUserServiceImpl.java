package com.li.affection.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.li.affection.domin.LoginUser;
import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.User;
import com.li.affection.mapper.UserMapper;
import com.li.affection.service.ModifyUserService;
import com.li.affection.untils.JwtUtils;
import com.li.affection.untils.RedisCache;
import com.li.affection.untils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ModifyUserServiceImpl implements ModifyUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult updatePassword(String password) {
        if (password == null) {
            return new ResponseResult(200,"密码不能为空");
        }
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        LoginUser loginUser = ServiceUtils.getLoginUser();
        User user = loginUser.getUser();
        wrapper.eq("id",user.getId());
        user.setPassword(passwordEncoder.encode(password));
        int update = userMapper.update(user, wrapper);
        if (update>0) {
            redisCache.deleteObject("login:"+user.getId());
            return new ResponseResult(200,"修改密码成功");
        }
        return new ResponseResult(200,"修改密码失败");
    }

    @Override
    public ResponseResult checkPassword(String password) {
        if (password == null) {
            return new ResponseResult(200,"密码为空");
        }
        LoginUser loginUser = ServiceUtils.getLoginUser();
        String oldPassword = loginUser.getUser().getPassword();
        if (passwordEncoder.matches(password,oldPassword)) {
            return new ResponseResult(200,"密码正确");
        }
        return new ResponseResult(200,"密码错误");
    }

    @Override
    public ResponseResult deleteUser(User user) {
        return null;
    }

    @Override
    public ResponseResult addUser(User user) {
        if (user.getUserName() == null || user.getPassword() == null) {
            return new ResponseResult(200, "用户不能为空");
        }
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName,user.getUserName());
        List<User> users = userMapper.selectList(wrapper);
        if (users != null && users.size()>0) {
            return new ResponseResult(200,"用户名重复");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        int insert = userMapper.insert(user);
        if (insert>0) {
            User newUser = userMapper.selectOne(wrapper);
            String userId = String.valueOf(newUser.getId());
            String jwt = JwtUtils.createJWT(userId);
            LoginUser loginUser = new LoginUser(newUser);
            redisCache.setCacheObject("login:"+userId,loginUser);
            HashMap<String,String> map = new HashMap<>();
            map.put("token",jwt);
            return new ResponseResult(200,"注册成功",map);
        }
        return new ResponseResult(200,"注册失败");
    }

    @Override
    public ResponseResult checkUserName(String username) {
        if (username == null) {
            return new ResponseResult(200,"用户名不能为空");
        }
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUserName,username);
        List<User> users = userMapper.selectList(wrapper);
        if (users != null && users.size()>0) {
            return new ResponseResult(200,"用户名重复");
        }
        return new ResponseResult(200,"用户名可以使用");
    }
}
