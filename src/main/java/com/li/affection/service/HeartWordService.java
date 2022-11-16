package com.li.affection.service;

import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.HeartWord;

public interface HeartWordService {
    ResponseResult getHeartWord();
    ResponseResult updateHeartWord(HeartWord heartWord);
    ResponseResult addHeartWord(HeartWord heartWord);
}
