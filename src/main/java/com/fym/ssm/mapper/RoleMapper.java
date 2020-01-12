package com.fym.ssm.mapper;

import com.fym.ssm.domain.Role;
import com.fym.ssm.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
public interface RoleMapper {
    void save(Role dept);
    void delete(Long id);
    void update(Role r);
    Role get(Long id);
    List<Role> list();
    List<Role> getListData(QueryObject qo);
    Long getTotalCount(QueryObject qo);
    void saveRelation(@Param("roleId") Long id, @Param("permissionId") Long id2);

    /**
     * 删除中间表中的关系
     * @param id 角色的id
     */
    void deleteRelation(Long id);
}
