package com.li.affection.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.li.affection.domin.LoginUser;
import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.HeartWord;
import com.li.affection.mapper.HeartWordMapper;
import com.li.affection.service.HeartWordService;
import com.li.affection.untils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeartWordServiceImpl implements HeartWordService {
    @Autowired
    private HeartWordMapper heartWordMapper;
    @Override
    public ResponseResult getHeartWord() {
        LoginUser loginUser = ServiceUtils.getLoginUser();
        Long id = loginUser.getUser().getId();
        LambdaQueryWrapper<HeartWord> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(HeartWord::getUserId,id);
        HeartWord heartWord = heartWordMapper.selectOne(wrapper);
        return new ResponseResult(200,"查询成功",heartWord);
    }

    @Override
    public ResponseResult updateHeartWord(HeartWord heartWord) {
        HeartWord selectHeartWord = (HeartWord) getHeartWord().getData();
        if (selectHeartWord == null) {
           return addHeartWord(heartWord);
        }
        if (heartWord.getHeartWords() == null) {
            heartWord.setHeartWords("");
        }
        heartWord.setVersion(selectHeartWord.getVersion());
        UpdateWrapper<HeartWord> wrapper = new UpdateWrapper<>();
        wrapper.eq("user_id",selectHeartWord.getUserId());
        int update = heartWordMapper.update(heartWord, wrapper);
        if (update > 0) {
            return new ResponseResult(200,"更新成功");
        }
        return new ResponseResult(200,"更新失败");
    }

    @Override
    public ResponseResult addHeartWord(HeartWord heartWord) {
        Long id = ServiceUtils.getLoginUser().getUser().getId();
        heartWord.setUserId(id);
        int insert = heartWordMapper.insert(heartWord);
        if (insert>0) {
            return new ResponseResult(200,"插入成功");
        }
        return new ResponseResult(200,"插入失败");
    }

}
