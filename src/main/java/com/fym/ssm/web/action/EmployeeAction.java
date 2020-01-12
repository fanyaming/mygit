package com.fym.ssm.web.action;

import com.fym.ssm.domain.Department;
import com.fym.ssm.domain.Employee;
import com.fym.ssm.domain.RequiedPermission;
import com.fym.ssm.domain.Role;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.EmployeeQueryObject;
import com.fym.ssm.service.IDepartmentService;
import com.fym.ssm.service.IEmployeeService;
import com.fym.ssm.service.IRoleService;
import com.opensymphony.xwork2.ActionContext;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
public class EmployeeAction extends BaseAction {
    @Setter
    private IEmployeeService service;
    @Setter
    private IDepartmentService deptService;
    @Setter
    private IRoleService roleService;
    @Setter@Getter
    private Employee emp = new Employee();
    @Getter
    private  EmployeeQueryObject qo =  new EmployeeQueryObject();
    @RequiedPermission("员工列表")
    public String execute() throws Exception {
        List<Department> depts = deptService.list();
        put("depts",depts);
        List<Role> roles = roleService.list();
        put("roles",roles);
        PageResult result = service.pageQuery(qo);
        ActionContext.getContext().put("result",result);
        return LIST;
    }
    @RequiedPermission("删除员工")
    public String delete() throws Exception {
        service.delete(emp.getId());
        return SUCCESS;
    }
    @RequiedPermission("编辑员工")
    public String input() throws Exception {
        List<Department> depts = deptService.list();
        put("depts",depts);
        List<Role> roles = roleService.list();
        put("roles",roles);
        if(emp!=null && emp.getId()!=null){
            emp= service.get(emp.getId());
        }
        return INPUT;
    }
    @RequiedPermission("保存或更新员工")
    public String saveOrUpdate() throws Exception {
        if(emp!=null && emp.getId()!=null){
            service.update(emp);
        }else{
            service.save(emp);
        }
        return SUCCESS;
    }
}
