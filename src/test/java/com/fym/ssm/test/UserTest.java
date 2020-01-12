package com.fym.ssm.test;

import com.fym.ssm.domain.User;
import com.fym.ssm.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lenovo on 2020/1/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserTest {
    @Autowired
    private IUserService userService;
    @Test
    public void test() throws  Exception{
     User user = new User();
        user.setName("haha");
        userService.save(user);
        System.out.println(userService);
    }
}
