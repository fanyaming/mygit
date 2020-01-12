package com.fym.ssm.service.impl;

import com.fym.ssm.domain.Permission;
import com.fym.ssm.domain.RequiedPermission;
import com.fym.ssm.mapper.PermissionMapper;
import com.fym.ssm.page.PageResult;
import com.fym.ssm.query.QueryObject;
import com.fym.ssm.service.IPermissionService;
import com.fym.ssm.web.action.BaseAction;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by lenovo on 2020/1/2.
 */
public class PermissionServiceImpl  implements IPermissionService ,ApplicationContextAware{
    @Setter
    private PermissionMapper mapper;
    private ApplicationContext applicationContext;
    @Override
    public void save(Permission p) {
        mapper.save(p);
    }
    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }
    @Override
    public List<Permission> list() {
        return mapper.list();
    }
    @Override
    public PageResult pageQuery(QueryObject qo) {
        Long totalCount = mapper.getTotalCount(qo);
        if(totalCount==0){
            return  PageResult.EMPTY_RESULT;
        }
        List<Permission> listData = mapper.getListData(qo);
        return new PageResult(listData,qo.getCurrentPage(),qo.getPageSize(),totalCount.intValue());
    }

    @Override
    public void reload() {
        List<Permission> list = mapper.list();
        Set<String> permissionSet = new HashSet<>();
        for (Permission permission : list) {
            String expression = permission.getExpression();
            permissionSet.add(expression);
        }
        //权限表达式=action类的权限定名:方法名称
        Map<String, BaseAction> actionMap = applicationContext.getBeansOfType(BaseAction.class);
        Collection<BaseAction> actions = actionMap.values();
        for (BaseAction action : actions) {
            Method[] methods = action.getClass().getDeclaredMethods();
            for (Method method : methods) {
                //判断方法上是否有当前自定义的注解
                if(method.isAnnotationPresent(RequiedPermission.class)){
                    RequiedPermission annotation = method.getAnnotation(RequiedPermission.class);
                    String actionName = action.getClass().getName();
                    String methodName = method.getName();
                    String expressions = actionName+":"+methodName;
                    if(!permissionSet.contains(expressions)){
                        Permission permission = new Permission();
                        permission.setName(annotation.value());
                        permission.setExpression(expressions);
                        mapper.save(permission);
                    }
                }
            }
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
