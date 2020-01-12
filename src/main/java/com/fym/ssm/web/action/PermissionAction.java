package com.fym.ssm.web.action;

import com.fym.ssm.domain.Permission;
import com.fym.ssm.domain.RequiedPermission;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.QueryObject;
import com.fym.ssm.service.IPermissionService;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by lenovo on 2020/1/2.
 */
public class PermissionAction extends BaseAction {
    @Setter
    private IPermissionService service;
    @Setter@Getter
    private Permission p;
    @Getter
    private QueryObject qo = new QueryObject();
    @RequiedPermission("权限列表")
    public String execute() throws Exception {
        PageResult result = service.pageQuery(qo);
        put("result",result);
        return LIST;
    }
    @RequiedPermission("删除权限")
    public String delete() throws Exception {
        service.delete(p.getId());
        return SUCCESS;
    }
    @RequiedPermission("加载权限")
    public String reload() throws Exception {
        service.reload();
        return NONE;
    }
}
