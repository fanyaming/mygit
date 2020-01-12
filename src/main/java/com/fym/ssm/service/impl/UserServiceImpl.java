package com.fym.ssm.service.impl;

import com.fym.ssm.domain.User;
import com.fym.ssm.mapper.UserMapper;
import com.fym.ssm.service.IUserService;
import lombok.Setter;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
public class UserServiceImpl implements IUserService {
    @Setter
    private UserMapper userMapper;
    @Override
    public void save(User u) {
        userMapper.save(u);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User u) {

    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public List<User> list() {
        return null;
    }
}
