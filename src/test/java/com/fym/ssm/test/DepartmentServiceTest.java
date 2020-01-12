package com.fym.ssm.test;

import com.fym.ssm.domain.Department;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.QueryObject;
import com.fym.ssm.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by lenovo on 2020/1/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DepartmentServiceTest {
    @Autowired
    private IDepartmentService deptService;

    @Test
    public void testSave() throws Exception {
        Department dept = new Department();
        dept.setName("研发部");
        dept.setSn("001");
        deptService.save(dept);
    }

    @Test
    public void testDelete() throws Exception {
        deptService.delete(4L);
    }

    @Test
    public void testUpdate() throws Exception {
        Department dept = new Department();
        dept.setId(1L);
        dept.setName("运维部");
        dept.setSn("002");
        deptService.update(dept);
    }

    @Test
    public void testGet() throws Exception {
        Department department = deptService.get(1L);
        System.out.println(department);
    }

    @Test
    public void testList() throws Exception {
        List<Department> lists = deptService.list();
        for (Department list : lists) {
            System.out.println(list);
        }
    }
    @Test
    public void testPageQuery() throws  Exception{
        QueryObject qo = new QueryObject();
        qo.setCurrentPage(1);
        qo.setPageSize(2);
        PageResult result = deptService.pageQuery(qo);
        System.out.println(result);
    }
}
