package com.fym.ssm.service.impl;

import com.fym.ssm.domain.Employee;
import com.fym.ssm.domain.Permission;
import com.fym.ssm.domain.Role;
import com.fym.ssm.mapper.EmployeeMapper;
import com.fym.ssm.mapper.PermissionMapper;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.EmployeeQueryObject;
import com.fym.ssm.service.IEmployeeService;
import com.opensymphony.xwork2.ActionContext;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on 2020/1/3.
 */
public class EmployeeServiceImpl implements IEmployeeService {
    @Setter
    private EmployeeMapper empMapper;
    @Setter
    private PermissionMapper permissionMapper;
    @Override
    public void save(Employee emp) {
        empMapper.save(emp);
        List<Role> roles = emp.getRoles();
        for (Role role : roles) {
            empMapper.saveRelation(emp.getId(),role.getId());
        }
    }

    @Override
    public void delete(Long id) {
        empMapper.deleteRelation(id);
        empMapper.delete(id);
    }

    @Override
    public void update(Employee emp) {
        empMapper.update(emp);
        empMapper.deleteRoleRelation(emp.getId());
        List<Role> roles = emp.getRoles();
        for (Role role : roles) {
            empMapper.saveRelation(emp.getId(),role.getId());
        }
    }

    @Override
    public Employee get(Long id) {
        return empMapper.get(id);
    }

    @Override
    public List<Employee> list() {
        return empMapper.list();
    }

    @Override
    public PageResult pageQuery(EmployeeQueryObject qo) {
        Long totalCount = empMapper.getTotalCount(qo);
        if(totalCount==0){
            return  PageResult.EMPTY_RESULT;
        }
        List<Employee> listData = empMapper.getListData(qo);
        return new PageResult(listData,qo.getCurrentPage(),qo.getPageSize(),totalCount.intValue());
    }

    @Override
    public Employee checkLogin(String username, String password) {
        //定义一个集合用来存放权限表达式
        Set<String> expressions = new HashSet<>();
        Employee e = empMapper.checkLogin(username, password);
        //得到员工拥有的权限
        if(e!=null) {
            List<Role> roles = e.getRoles();
            for (Role role : roles) {
                List<Permission> permissions = permissionMapper.getPermissionsByRoleId(role.getId());
                for (Permission permission : permissions) {
                    String expression = permission.getExpression();
                    expressions.add(expression);
                }
            }
        }
        ActionContext.getContext().getSession().put("EXPRESSION_IN_SESSION",expressions);
        return e;
    }
}
