package com.li.affection.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.li.affection.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
