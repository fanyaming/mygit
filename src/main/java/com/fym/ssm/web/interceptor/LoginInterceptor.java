package com.fym.ssm.web.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

/**z自定义拦截器类
 * Created by lenovo on 2019/12/27.
 */
public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> session = actionInvocation.getInvocationContext().getSession();
        Object o = session.get("EMPLOYEE_IN_SESSION");
        if(o==null){
            return Action.LOGIN;
        }
        return actionInvocation.invoke();
    }
}
