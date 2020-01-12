package com.fym.ssm.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by lenovo on 2020/1/3.
 */
@Setter@Getter@ToString
public class EmployeeQueryObject extends QueryObject{
    private String keywords;
    private Long deptId;
}
