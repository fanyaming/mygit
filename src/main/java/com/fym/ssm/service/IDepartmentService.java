package com.fym.ssm.service;

import com.fym.ssm.domain.Department;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.QueryObject;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
public interface IDepartmentService {
    void save(Department dept);
    void delete(Long id);
    void update(Department dept);
    Department get(Long id);
    List<Department> list();
    PageResult pageQuery(QueryObject qo);
}
