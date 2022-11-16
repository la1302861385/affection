package com.li.affection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.affection.entity.UserDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDetailMapper extends BaseMapper<UserDetail> {
    List<UserDetail> listUserDetails();
}
