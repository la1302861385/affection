package com.li.affection.service;

import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.User;

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
