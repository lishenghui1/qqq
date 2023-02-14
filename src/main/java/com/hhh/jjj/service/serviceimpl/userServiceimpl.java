package com.hhh.jjj.service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hhh.jjj.mapper.userMapper;
import com.hhh.jjj.po.User;
import com.hhh.jjj.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service


public class userServiceimpl implements userService {
    @Autowired
    userMapper usermapper;
    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public User select(User user) {
        QueryWrapper<User> queryWrapper =new QueryWrapper();
        queryWrapper.eq("name",user.name);
        return usermapper.selectOne(queryWrapper);
    }
}
