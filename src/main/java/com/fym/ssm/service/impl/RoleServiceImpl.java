package com.fym.ssm.service.impl;

import com.fym.ssm.domain.Permission;
import com.fym.ssm.domain.Role;
import com.fym.ssm.mapper.PermissionMapper;
import com.fym.ssm.mapper.RoleMapper;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.QueryObject;
import com.fym.ssm.service.IRoleService;
import lombok.Setter;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
public class RoleServiceImpl implements IRoleService{
    @Setter
    private RoleMapper roleMapper;
    @Setter
    private PermissionMapper permissionMapper;

    @Override
    public void save(Role r) {
        roleMapper.save(r);
        //把对应的关系保存到中间表中
        List<Permission> permissions = r.getPermissions();
        for (Permission permission : permissions) {
            roleMapper.saveRelation(r.getId(),permission.getId());
        }
    }

    @Override
    public void delete(Long id) {
        roleMapper.delete(id);
    }

    @Override
    public void update(Role r) {
        roleMapper.update(r);//更新role表中的数据
        roleMapper.deleteRelation(r.getId());
        List<Permission> permissions = r.getPermissions();
        for (Permission permission : permissions) {
            roleMapper.saveRelation(r.getId(),permission.getId());
        }
    }

    @Override
    public Role get(Long id) {
        return roleMapper.get(id);
    }

    @Override
    public List<Role> list() {

        return roleMapper.list();
    }

    @Override
    public PageResult pageQuery(QueryObject qo) {
        Long totalCount = roleMapper.getTotalCount(qo);
        if(totalCount==0){
            return  PageResult.EMPTY_RESULT;
        }
        List<Role> listData = roleMapper.getListData(qo);
        return new PageResult(listData,qo.getCurrentPage(),qo.getPageSize(),totalCount.intValue());
    }
}
