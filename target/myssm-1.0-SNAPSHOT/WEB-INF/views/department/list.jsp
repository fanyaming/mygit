<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/1/2
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/style/basic_layout.css" rel="stylesheet" type="text/css">
    <link href="/style/common_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="/js/commonAll.js"></script>
    <title>PSS-部门管理</title>
    <style>
        .alt td{ background:black !important;}
    </style>
    <script type="text/javascript">
        $(function(){
            $(".btn_input").click(function(){
                window.location.href=$(this).data("url");
            });
        });
    </script>
    <script type="text/javascript">
        function goPage(currentPage) {
            document.getElementById("currentPage").value=currentPage;
            document.forms[0].submit();
        }
    </script>
</head>
<body>
<form id="searchForm" action="#" method="post">
    <div id="container">
        <div class="ui_content">
            <div class="ui_text_indent">
                <div id="box_border">
                    <div id="box_top">搜索</div>
                    <div id="box_bottom">
                       <s:a namespace="/" action="department_input">新增</s:a>
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
                        <th>部门名称</th>
                        <th>部门代码</th>
                        <th></th>
                    </tr>
                    <tbody>
                    <s:iterator value="#result.listData">
                    <tr>
                        <td><input type="checkbox" name="IDCheck" class="acb" /></td>
                        <td>
                            <s:property value="id"/>
                        </td>
                        <td>
                            <s:property value="name"/>
                        </td>
                        <td>
                            <s:property value="sn"/>
                        </td>
                        <td>
                            <s:a namespace="/" action="department_input">编辑
                            <s:param name="dept.id" value="id"/>
                            </s:a>
                            <s:a namespace="/" action="department_delete">删除
                                <s:param name="dept.id" value="id"/>
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
</form>
</body>
</html>

