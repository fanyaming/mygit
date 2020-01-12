package com.fym.ssm.service;

import com.fym.ssm.domain.Role;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.QueryObject;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
public interface IRoleService {
    void save(Role r);
    void delete(Long id);
    void update(Role r);
    Role get(Long id);
    List<Role> list();
    PageResult pageQuery(QueryObject qo);
}
