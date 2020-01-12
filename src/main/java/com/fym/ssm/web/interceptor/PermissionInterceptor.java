package com.fym.ssm.web.interceptor;

import com.fym.ssm.domain.Employee;
import com.fym.ssm.domain.RequiedPermission;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/**z自定义拦截器类
 * Created by lenovo on 2019/12/27.
 */
public class PermissionInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        Employee e = (Employee) session.get("EMPLOYEE_IN_SESSION");
        Set<String> expressions = (Set<String>) session.get("EXPRESSION_IN_SESSION");

        //如果是超级管理员,不需要检验
        if(e.isAdmin()){
            return actionInvocation.invoke();
        }
        //如果方法上没有权限的注释.也不需要检验
        Object action = actionInvocation.getProxy().getAction();
        String methodName = actionInvocation.getProxy().getMethod();
        Method method = action.getClass().getMethod(methodName);
        if(!method.isAnnotationPresent(RequiedPermission.class)){
            return actionInvocation.invoke();
        }
        //如果该用户有该权限,也可以
        String actionName = action.getClass().getName();
        String expression = actionName+":"+methodName;
        if(!expressions.contains(expression)){
            return "nopermission";
        }
        //其他情况返回一个无此权限的页面
        return actionInvocation.invoke();
    }
}
