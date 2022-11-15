package com.li.affection.service;

import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.UserDetail;

public interface UserDetailService {
    ResponseResult listUserDetails();
    ResponseResult selectUserDetail();
    ResponseResult updateUserDetail(UserDetail userDetail);
    ResponseResult addUserDetail(UserDetail userDetail);
}
