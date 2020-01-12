package com.fym.ssm.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by lenovo on 2020/1/3.
 */
@Getter@Setter@ToString
public class BaseDomain implements Serializable {
    private Long id;
}
