package com.fym.ssm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2020/1/3.
 */
@Getter@Setter
public class Employee extends BaseDomain{
    private String name;
    private String password;
    private String email;
    private Integer age;
    private boolean admin;
    @Getter@Setter
    private Department dept;
    private List<Role> roles =new ArrayList<>();


    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", admin=" + admin +
                '}';
    }
}
