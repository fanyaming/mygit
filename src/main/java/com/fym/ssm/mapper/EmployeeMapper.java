package com.fym.ssm.mapper;

import com.fym.ssm.domain.Employee;
import com.fym.ssm.query.EmployeeQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
public interface EmployeeMapper {
    void save(Employee emp);
    void delete(Long id);
    void update(Employee emp);
    Employee get(Long id);
    List<Employee> list();
    List<Employee> getListData(EmployeeQueryObject qo);
    Long getTotalCount(EmployeeQueryObject qo);
    void deleteRelation(Long id);

    /**
     * 保存关系到中间表中
     * @param id
     * @param id1
     */
    void saveRelation(@Param("empId") Long id, @Param("roleId") Long id1);

    /**
     * 删除员工和角色的关系
     * @param id 员工的id
     */
    void deleteRoleRelation(Long id);

    Employee checkLogin(@Param("username") String username,@Param("password") String password);
}
