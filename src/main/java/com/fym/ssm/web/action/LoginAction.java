package com.fym.ssm.web.action;

import com.fym.ssm.domain.Employee;
import com.fym.ssm.service.IEmployeeService;
import com.opensymphony.xwork2.ActionContext;
import lombok.Setter;

/**
 * Created by lenovo on 2020/1/5.
 */
public class LoginAction extends BaseAction {
    @Setter
    private String username;
    @Setter
    private String password;
    @Setter
    private IEmployeeService employeeService;
    @Override
    public String execute() throws Exception {
        Employee e = employeeService.checkLogin(username, password);
        if(e==null){
            addActionError("您的账号或者密码有错误");
            return LOGIN;
        }else {
            ActionContext.getContext().getSession().put("EMPLOYEE_IN_SESSION", e);
            return "main";
        }
    }
}
