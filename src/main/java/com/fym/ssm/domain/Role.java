package com.fym.ssm.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
@Getter@Setter
public class Role extends BaseDomain{
    private String name;
    private String sn;
    private List<Permission> permissions = new ArrayList<>();

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", sn='" + sn + '\'' +
                '}';
    }
}
