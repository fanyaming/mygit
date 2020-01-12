package com.fym.ssm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by lenovo on 2020/1/3.
 */
public class BaseAction extends ActionSupport{
    public static final String LIST = "list";
    protected void put(String name,Object value){
        ActionContext.getContext().put(name,value);
    }
}
