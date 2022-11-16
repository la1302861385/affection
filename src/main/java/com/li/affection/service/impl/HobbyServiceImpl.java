package com.li.affection.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.li.affection.domin.LoginUser;
import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.Hobby;
import com.li.affection.mapper.HobbyMapper;
import com.li.affection.service.HobbyService;
import com.li.affection.untils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HobbyServiceImpl implements HobbyService {
    @Autowired
    private HobbyMapper hobbyMapper;
    @Override
    public ResponseResult getHobby() {
        LoginUser loginUser = ServiceUtils.getLoginUser();
        Long id = loginUser.getUser().getId();
        LambdaQueryWrapper<Hobby> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Hobby::getUserId,id);
        Hobby hobby = hobbyMapper.selectOne(wrapper);
        return new ResponseResult(200,"查询成功",hobby);
    }

    @Override
    public ResponseResult updateHobby(Hobby hobby) {
       Hobby selectHobby = (Hobby) getHobby().getData();
        if (selectHobby == null) {
            return addHobby(hobby);
        }
        if (hobby.getFavoriteBook() == null) {
            hobby.setFavoriteBook("");
        }
        if (hobby.getFavoritePerson() == null) {
            hobby.setFavoritePerson("");
        }
        if (hobby.getFavoriteFood() == null) {
            hobby.setFavoriteFood("");
        }
        if (hobby.getFavoriteDoing() == null) {
            hobby.setFavoriteDoing("");
        }
        if (hobby.getFavoriteSong() == null) {
            hobby.setFavoriteSong("");
        }
        hobby.setVersion(selectHobby.getVersion());
        UpdateWrapper<Hobby> wrapper = new UpdateWrapper<>();
        wrapper.eq("user_id",selectHobby.getUserId());
        int update = hobbyMapper.update(hobby, wrapper);
        if (update > 0) {
            return new ResponseResult(200,"更新成功");
        }
        return new ResponseResult(200,"更新失败");
    }

    @Override
    public ResponseResult addHobby(Hobby hobby) {
        Long id = ServiceUtils.getLoginUser().getUser().getId();
        hobby.setUserId(id);
        int insert = hobbyMapper.insert(hobby);
        if (insert>0) {
            return new ResponseResult(200,"插入成功");
        }
        return new ResponseResult(200,"插入失败");
    }

}


