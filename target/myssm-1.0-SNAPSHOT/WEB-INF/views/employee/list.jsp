<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/1/3
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="style/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="style/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="js/jquery/jquery.js"></script>
    <script type="text/javascript" src="js/commonAll.js"></script>
    <title>PSS-员工管理</title>
    <style>
        .alt td{ background:black !important;}
    </style>
    <script type="text/javascript">
        function goPage(currentPage) {
            document.getElementById("currentPage").value=currentPage;
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<s:form id="searchForm"  namespace="/" action="employee">
    <div id="container">
        <div class="ui_content">
            <div class="ui_text_indent">
                <div id="box_border">
                    <div id="box_top">搜索</div>
                    <div id="box_center">
                        姓名/邮箱
                        <input type="text" class="ui_input_txt02" name="qo.keywords" />
                        <s:select list="#depts" name="qo.deptId" listKey="id"
                                  listValue="name" headerKey="-1" headerValue="--请选择--"/>
                    </div>
                    <div id="box_bottom">
                        <input type="submit" value="查询" class="ui_input_btn01"/>
                        <s:a namespace="/" action="employee_input">新增</s:a>
                    </div>
                </div>
            </div>
        </div>
        <div class="ui_content">
            <div class="ui_tb">
                <table class="table" cellspacing="0" cellpadding="0" width="100%" align="center" border="0">
                    <tr>
                        <th width="30"><input type="checkbox" id="all" /></th>
                        <th>编号</th>
                        <th>用户名</th>
                        <th>EMAIL</th>
                        <th>年龄</th>
                        <th>所属部门</th>
                        <%--<th>角色</th>--%>
                        <th></th>
                    </tr>
                    <tbody>
                    <s:iterator value="#result.listData">
                    <tr>
                        <td><input type="checkbox" name="IDCheck" class="acb" /></td>
                        <td>
                            <s:property value="id"/>
                        </td>
                        <td><s:property value="name"/></td>
                        <td><s:property value="email"/></td>
                        <td><s:property value="age"/></td>
                        <td><s:property value="dept.name"/></td>
                       <%-- <td><s:property value="roles.name"/></td>--%>
                        <td>
                            <s:a namespace="/" action="employee_input">编辑
                                <s:param name="emp.id" value="id"/>
                            </s:a>
                            <s:a namespace="/" action="employee_delete">删除
                                <s:param name="emp.id" value="id"/>
                            </s:a>
                        </td>
                    </tr>
                    </s:iterator>
                    </tbody>
                </table>
            </div>
            <s:include  value="/commons/common_page.jsp" />
        </div>
    </div>
</s:form>
</body>
</html>

