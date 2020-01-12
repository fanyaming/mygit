<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020/1/3
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="ui_tb_h30">
    <div class="ui_flt" style="height: 30px; line-height: 30px;">
        共有
        <span class="ui_txt_bold04">
                        <s:property value="#result.totalCount"/>
                    </span>
        条记录，当前第
        <span class="ui_txt_bold04">
                        <s:property value="#result.currentPage"/>
                        /
                        <s:property value="#result.totalPage"/>
                    </span>
        页
    </div>
    <div class="ui_frt">
        <input type="button" value="首页" class="ui_input_btn01" onclick="goPage(1)"/>
        <input type="button" value="上一页" class="ui_input_btn01" onclick="goPage('<s:property value="#result.prevPage"/>')"/>
        <input type="button" value="下一页" class="ui_input_btn01"
               onclick="goPage('<s:property value="#result.nextPage"/>')"/>
        <input type="button" value="尾页" class="ui_input_btn01"
               onclick="goPage(
                       '<s:property value="#result.totalPage"/>'
                       )"/>

        <select list="{5,10,15}" name="qo.pageSize" class="ui_select02" onchange="goPage(1)">
            <option>5</option>
            <option>10</option>
            <option>15</option>
        </select>
        转到第<s:textfield name="qo.currentPage" id="currentPage"  class="ui_input_txt01" />页
        <input type="submit" class="ui_input_btn01" value="跳转"/>
    </div>
</div>
