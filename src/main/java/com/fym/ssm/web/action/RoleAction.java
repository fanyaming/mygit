package com.fym.ssm.web.action;

import com.fym.ssm.domain.Permission;
import com.fym.ssm.domain.Role;
import com.fym.ssm.domain.RequiedPermission;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.QueryObject;
import com.fym.ssm.service.IPermissionService;
import com.fym.ssm.service.IRoleService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
public class RoleAction extends BaseAction {
    @Setter
    private IRoleService roleService;
    @Setter
    private IPermissionService permissionService;
    @Setter@Getter
    private Role role = new Role();
    @Getter
    private QueryObject qo = new QueryObject();
    @RequiedPermission("角色列表")
    public String execute() throws Exception {
        PageResult result = roleService.pageQuery(qo);
        put("result",result);
        return LIST;
    }
    @RequiedPermission("删除角色")
    public String delete() throws Exception {
        roleService.delete(role.getId());
        return SUCCESS;
    }
    @RequiedPermission("编辑角色")
    public String input() throws Exception {
        //跳转到编辑页面时,需要查询出所有的权限信息
        List<Permission> permissions = permissionService.list();
        put("permissions",permissions);
        if(role!=null && role.getId()!=null){
            role= roleService.get(role.getId());
        }
        return INPUT;
    }
    @RequiedPermission("新增或更新角色")
    public String saveOrUpdate() throws Exception {
        if(role!=null && role.getId()!=null){
            roleService.update(role);
        }else{
            roleService.save(role);
        }
        return SUCCESS;
    }
}
