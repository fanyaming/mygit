package com.fym.ssm.web.action;

import com.fym.ssm.domain.Department;
import com.fym.ssm.domain.RequiedPermission;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.QueryObject;
import com.fym.ssm.service.IDepartmentService;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by lenovo on 2020/1/2.
 */
public class DepartmentAction extends BaseAction {
    @Setter
    private IDepartmentService service;
    @Setter@Getter
    private Department dept;
    @Getter
    private QueryObject qo = new QueryObject();
    @RequiedPermission("部门列表")
    public String execute() throws Exception {
        PageResult result = service.pageQuery(qo);
        put("result",result);
        return LIST;
    }
    @RequiedPermission("删除部门")
    public String delete() throws Exception {
        service.delete(dept.getId());
        return SUCCESS;
    }
    @RequiedPermission("编辑部门")
    public String input() throws Exception {
        if(dept!=null && dept.getId()!=null){
           dept= service.get(dept.getId());
        }
        return INPUT;
    }
    @RequiedPermission("新增或更新部门")
    public String saveOrUpdate() throws Exception {
        if(dept!=null && dept.getId()!=null){
            service.update(dept);
        }else{
            service.save(dept);
        }
        return SUCCESS;
    }
}
