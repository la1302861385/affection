package com.li.affection.service;

import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.User;

public interface ModifyUserService {
    ResponseResult updatePassword(String password);

    ResponseResult deleteUser(User user);

    ResponseResult addUser(User user);

    ResponseResult checkPassword(String password);

    ResponseResult checkUserName(String username);
}
