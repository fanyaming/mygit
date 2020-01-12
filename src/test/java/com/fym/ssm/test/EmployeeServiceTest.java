package com.fym.ssm.test;

import com.fym.ssm.domain.Employee;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.EmployeeQueryObject;
import com.fym.ssm.service.IEmployeeService;
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
public class EmployeeServiceTest {
    @Autowired
    private IEmployeeService empService;

    @Test
    public void testSave() throws Exception {
        Employee employee = new Employee();
        employee.setName("小明");
        employee.setPassword("1234");
        employee.setEmail("xiaomingqq.com");
        employee.setAge(20);
        employee.setAdmin(true);
        empService.save(employee);
    }

    @Test
    public void testDelete() throws Exception {
        empService.delete(1L);
    }

    @Test
    public void testUpdate() throws Exception {
        Employee employee = new Employee();
        employee.setId(2L);
        employee.setName("小红");
        employee.setAge(18);
        employee.setPassword("1111");
        employee.setAdmin(false);
        empService.update(employee);
    }

    @Test
    public void testGet() throws Exception {
        Employee employee = empService.get(1L);
        System.out.println(employee);
    }

    @Test
    public void testList() throws Exception {
        List<Employee> lists = empService.list();
        for (Employee list : lists) {
            System.out.println(list);
        }
    }
    @Test
    public void testPageQuery() throws  Exception{
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setCurrentPage(1);
        qo.setPageSize(2);
        PageResult result = empService.pageQuery(qo);
        System.out.println(result);
    }
}
