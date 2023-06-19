package com.whw.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whw.entity.User;
import com.whw.mapper.UserMapper;
import com.whw.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
