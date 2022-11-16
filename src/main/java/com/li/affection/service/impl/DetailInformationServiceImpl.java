package com.li.affection.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.li.affection.domin.LoginUser;
import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.DetailInformation;
import com.li.affection.mapper.DetailInformationMapper;
import com.li.affection.service.DetailInformationService;
import com.li.affection.untils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailInformationServiceImpl implements DetailInformationService {
    @Autowired
    private DetailInformationMapper detailInformationMapper;
    @Override
    public ResponseResult getDetailInformation() {
        LoginUser loginUser = ServiceUtils.getLoginUser();
        Long id = loginUser.getUser().getId();
        LambdaQueryWrapper<DetailInformation> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(DetailInformation::getUserId,id);
        DetailInformation detailInformation = detailInformationMapper.selectOne(wrapper);
        return new ResponseResult(200,"查询成功",detailInformation);
    }

    @Override
    public ResponseResult updateDetailInformation(DetailInformation detailInformation) {
        DetailInformation selectDetailInformation = (DetailInformation) getDetailInformation().getData();
        if (selectDetailInformation == null) {
            return addDetailInformation(detailInformation);
        }
        detailInformation.setVersion(selectDetailInformation.getVersion());
        UpdateWrapper<DetailInformation> wrapper = new UpdateWrapper<>();
        wrapper.eq("user_id",selectDetailInformation.getUserId());
        int update = detailInformationMapper.update(detailInformation, wrapper);
        if (update > 0) {
            return new ResponseResult(200,"更新成功");
        }
        return new ResponseResult(200,"更新失败");
    }

    @Override
    public ResponseResult addDetailInformation(DetailInformation detailInformation) {
        Long id = ServiceUtils.getLoginUser().getUser().getId();
        detailInformation.setUserId(id);
        int insert = detailInformationMapper.insert(detailInformation);
        if (insert>0) {
            return new ResponseResult(200,"插入成功");
        }
        return new ResponseResult(200,"插入失败");
    }
}
