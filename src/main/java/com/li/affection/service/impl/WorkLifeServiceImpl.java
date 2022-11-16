package com.li.affection.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.li.affection.domin.LoginUser;
import com.li.affection.domin.ResponseResult;
import com.li.affection.entity.WorkLife;
import com.li.affection.mapper.WorkLifeMapper;
import com.li.affection.service.WorkLifeService;
import com.li.affection.untils.ServiceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkLifeServiceImpl implements WorkLifeService {
    @Autowired
    private WorkLifeMapper workLifeMapper;
    @Override
    public ResponseResult getWorkLife() {
        LoginUser loginUser = ServiceUtils.getLoginUser();
        Long id = loginUser.getUser().getId();
        LambdaQueryWrapper<WorkLife> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(WorkLife::getUserId,id);
        WorkLife workLife = workLifeMapper.selectOne(wrapper);
        return new ResponseResult(200,"查询成功",workLife);
    }

    @Override
    public ResponseResult updateWorkLife(WorkLife workLife) {
        WorkLife selectWorkLife = (WorkLife) getWorkLife().getData();
        if(selectWorkLife == null){
            return addWorkLife(workLife);
        }
        workLife.setVersion(selectWorkLife.getVersion());
        UpdateWrapper<WorkLife> wrapper = new UpdateWrapper<>();
        wrapper.eq("user_id",selectWorkLife.getUserId());
        int update = workLifeMapper.update(workLife, wrapper);
        if (update > 0) {
            return new ResponseResult(200,"更新成功");
        }
        return new ResponseResult(200,"更新失败");
    }

    @Override
    public ResponseResult addWorkLife(WorkLife workLife) {
        Long id = ServiceUtils.getLoginUser().getUser().getId();
        workLife.setUserId(id);
        int insert = workLifeMapper.insert(workLife);
        if (insert>0) {
            return new ResponseResult(200,"插入成功");
        }
        return new ResponseResult(200,"插入失败");
    }
}
