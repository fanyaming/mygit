package com.fym.ssm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by lenovo on 2020/1/2.
 */
@Getter@Setter@ToString
public class Permission extends BaseDomain{
    private String name;
    private String expression;
}
