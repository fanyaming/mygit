package com.fym.ssm.service;

import com.fym.ssm.domain.Employee;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.EmployeeQueryObject;

import java.util.List;

/**
 * Created by lenovo on 2020/1/3.
 */
public interface IEmployeeService {
    void save(Employee emp);
    void delete(Long id);
    void update(Employee emp);
    Employee get(Long id);
    List<Employee> list();
    PageResult pageQuery(EmployeeQueryObject qo);

    Employee checkLogin(String username, String password);
}
