package com.fym.ssm.service.impl;

import com.fym.ssm.domain.Department;
import com.fym.ssm.mapper.DepartmentMapper;
import com.fym.ssm.mapper.EmployeeMapper;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.QueryObject;
import com.fym.ssm.service.IDepartmentService;
import lombok.Setter;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
public class DepartmentServiceImpl implements IDepartmentService{
    @Setter
    private DepartmentMapper deptMapper;
    @Setter
    private EmployeeMapper empMapper;
    @Override
    public void save(Department dept) {
        deptMapper.save(dept);
    }

    @Override
    public void delete(Long id) {
        empMapper.deleteRelation(id);
        deptMapper.delete(id);
    }

    @Override
    public void update(Department dept) {
        deptMapper.update(dept);
    }

    @Override
    public Department get(Long id) {
        return deptMapper.get(id);
    }

    @Override
    public List<Department> list() {

        return deptMapper.list();
    }

    @Override
    public PageResult pageQuery(QueryObject qo) {
        Long totalCount = deptMapper.getTotalCount(qo);
        if(totalCount==0){
            return  PageResult.EMPTY_RESULT;
        }
        List<Department> listData = deptMapper.getListData(qo);
        return new PageResult(listData,qo.getCurrentPage(),qo.getPageSize(),totalCount.intValue());
    }
}
