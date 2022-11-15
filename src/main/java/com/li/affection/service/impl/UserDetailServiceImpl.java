package com.li.affection.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.li.affection.domin.LoginUser;
import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.UserDetail;
import com.li.affection.mapper.UserDetailMapper;
import com.li.affection.service.UserDetailService;
import com.li.affection.untils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    private UserDetailMapper userDetailMapper;

    @Override
    public ResponseResult listUserDetails() {
        List<UserDetail> userDetails = userDetailMapper.selectList(null);
        return new ResponseResult(200,"查询成功",userDetails);
    }

    @Override
    public ResponseResult selectUserDetail() {
        LoginUser loginUser = ServiceUtils.getLoginUser();
        Long id = loginUser.getUser().getId();
        LambdaQueryWrapper<UserDetail> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserDetail::getUserId,id);
        UserDetail userDetail = userDetailMapper.selectOne(wrapper);
        if (userDetail == null) {
            return new ResponseResult(200,"用户信息为空");
        }
        return new ResponseResult(200,"查询成功",userDetail);
    }

    @Override
    public ResponseResult updateUserDetail(UserDetail userDetail) {
        if (userDetail.getNickName() == null) {
            return new ResponseResult(200,"用户信息为空");
        }
        if (selectUserDetail().getData() == null) {
            return addUserDetail(userDetail);
        }
        UserDetail oldUserDetail = (UserDetail) selectUserDetail().getData();
        userDetail.setVersion(oldUserDetail.getVersion());
        UpdateWrapper<UserDetail> wrapper = new UpdateWrapper<>();
        wrapper.eq("user_id",oldUserDetail.getUserId());
        int update = userDetailMapper.update(userDetail, wrapper);
        if (update>0) {
            return new ResponseResult(200,"更新成功");
        }
        return new ResponseResult(200,"更新失败");
    }

    @Override
    public ResponseResult addUserDetail(UserDetail userDetail) {
        if (userDetail == null) {
            return new ResponseResult(200,"用户信息为空");
        }
        userDetail.setUserId(ServiceUtils.getLoginUser().getUser().getId());
        userDetail.setVersion(0L);
        int insert = userDetailMapper.insert(userDetail);
        if (insert>0) {
            return new ResponseResult(200,"插入成功");
        }

        return new ResponseResult(200,"插入失败");
    }
}
