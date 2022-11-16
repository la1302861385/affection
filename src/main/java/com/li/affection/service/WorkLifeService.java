package com.li.affection.service;

import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.WorkLife;

public interface WorkLifeService {
    ResponseResult getWorkLife();
    ResponseResult updateWorkLife(WorkLife workLife);
    ResponseResult addWorkLife(WorkLife workLife);
}
