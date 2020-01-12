package com.fym.ssm.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by lenovo on 2019/12/24.
 */
@Setter
@Getter
@ToString
public class QueryObject {
   private Integer currentPage=1;
   private Integer pageSize=5;
   public Integer getBeginIndex(){
       return (currentPage-1)*pageSize;
   }
}
