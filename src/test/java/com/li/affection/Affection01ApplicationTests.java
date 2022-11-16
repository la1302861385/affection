package com.li.affection;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.li.affection.entity.User;
import com.li.affection.entity.UserDetail;
import com.li.affection.mapper.UserDetailMapper;
import com.li.affection.mapper.UserMapper;
import com.li.affection.untils.RedisCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class Affection01ApplicationTests {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserDetailMapper userDetailMapper;
    @Test
    public void test(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name","1302861385");
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);

    }
    @Test
    public void test1(){
//        User user= new User();
//        user.setUserName("kak");
//        user.setPassword("llkla00000123");
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getDeleted,1);
         userMapper.selectOne(wrapper);

    }
    @Test
    public void test2(){
        for (UserDetail userDetail : userDetailMapper.listUserDetails()) {
            System.out.println(userDetail);
        }


    }

}
