package com.fym.ssm.service;

import com.fym.ssm.domain.Permission;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.QueryObject;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
public interface IPermissionService {
    void save(Permission p);
    void delete(Long id);
    List<Permission> list();
    PageResult pageQuery(QueryObject qo);

    /**
     * 加载权限的方法
     */
    void reload();
}
