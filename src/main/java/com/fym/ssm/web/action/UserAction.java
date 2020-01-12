package com.fym.ssm.web.action;

import com.fym.ssm.domain.User;
import com.fym.ssm.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import lombok.Setter;

/**
 * Created by lenovo on 2020/1/2.
 */
public class UserAction extends ActionSupport{
    @Setter
    private IUserService userService;
    @Override
    public String execute() throws Exception {
        User user = new User();
        user.setName("haha");
        userService.save(user);
        return NONE;
    }
}
