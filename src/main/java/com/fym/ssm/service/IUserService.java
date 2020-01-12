package com.fym.ssm.service;

import com.fym.ssm.domain.User;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
public interface IUserService {
    void save(User u);
    void delete(Long id);
    void update(User u);
    User get(Long id);
    List<User> list();

}
