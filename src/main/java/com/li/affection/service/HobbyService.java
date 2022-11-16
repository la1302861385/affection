package com.li.affection.service;

import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.Hobby;

public interface HobbyService {
    ResponseResult getHobby();
    ResponseResult updateHobby(Hobby hobby);
    ResponseResult addHobby(Hobby hobby);
}
