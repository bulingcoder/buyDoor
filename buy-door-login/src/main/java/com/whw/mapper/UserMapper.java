package com.whw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whw.entity.User;

import java.util.Map;


public interface UserMapper extends BaseMapper<User> {
    Map<String, Object> selectMapById(Long id);
    
}

