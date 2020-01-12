package com.fym.ssm.mapper;

import com.fym.ssm.domain.Department;
import com.fym.ssm.query.QueryObject;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
public interface DepartmentMapper {
    void save(Department dept);
    void delete(Long id);
    void update(Department dept);
    Department get(Long id);
    List<Department> list();
    List<Department> getListData(QueryObject qo);
    Long getTotalCount(QueryObject qo);
}
