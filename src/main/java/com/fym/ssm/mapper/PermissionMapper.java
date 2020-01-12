package com.fym.ssm.mapper;

import com.fym.ssm.domain.Permission;
import com.fym.ssm.query.QueryObject;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
public interface PermissionMapper {
    void save(Permission p);
    void delete(Long id);
    List<Permission> list();
    List<Permission> getListData(QueryObject qo);
    Long getTotalCount(QueryObject qo);

    /**
     * 根据角色id查询出对应的所有的权限
     * @param id 角色id
     * @return
     */
    List<Permission> getPermissionsByRoleId(Long id);
}
