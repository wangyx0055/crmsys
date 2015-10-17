<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CRM 管理中心 - 员工管理 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="./Styles/general.css" rel="stylesheet" type="text/css" />
<link href="./Styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>
    <span class="action-span"><a href="${path }/emp_toEdit.action">添加员工</a></span>
    <span class="action-span1"><a href="${path }/main_index.action">CRM 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 员工管理 </span>
    <div style="clear:both"></div>
</h1>
<div class="form-div">
    <form action="${path }/emp_list.action" id="searchForm" method="post">
        <img src="././Images/icon_search.gif" width="26" height="22" border="0" alt="search" />
       
        <!-- 隐藏条件 -->
        <s:hidden name="currentPage" id="currentPage"></s:hidden>
        <s:hidden name="pageSize" id="pageSize"></s:hidden>
        <!-- 姓名 -->
		姓名 <s:textfield name="condition.name" size="15"></s:textfield>
		电话 <s:textfield name="condition.phone" size="15"></s:textfield>
		邮箱 <s:textfield name="condition.email" size="15"></s:textfield>
		部门 <s:select name="condition.deptId" headerKey="-1" headerValue="--请选择--" list="#deptList" listKey="id" listValue="deptName"></s:select> 
		<s:textfield name="condition.address" size="15"></s:textfield>
		
        <input type="button" value=" 搜索 " class="button" onclick="gotoAction(1,<s:property value='%{pageSize}' />)"/>
    </form>
</div>

<!-- 员工列表 -->
<form method="post" action="" name="listForm" onsubmit="">
    <div class="list-div" id="listDiv">
        <table cellpadding="3" cellspacing="1">
            <tr>
                <th>员工编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>电话</th>
                <th>生日</th>
                <th>邮箱</th>
                <th>所属部门</th>
                <th>操作</th>
            </tr>
            <s:iterator value="pageBean.pageData">
            <tr>
                <td align="center"><s:property value="id"/></td>
                <td align="center" class="first-cell"><s:property value="empName"/></td>
                <td align="center"><s:property value="sex"/></td>
                <td align="center"><s:property value="phone"/></td>
                <td align="center"><s:date name="birth" format="yyyy-MM-dd"/></td>
                <td align="center"><s:property value="email"/></td>
                <td align="center"><s:property value="dept.deptName"/></td>
                <td align="center">
	                <s:a href="emp_toEdit.action?employee.id=%{id}" title="编辑"><img src="./Images/icon_edit.gif" width="16" height="16" border="0" /></s:a>
	                <s:a href="emp_delete.action?employee.id=%{id}" title="删除"><img src="./Images/icon_trash.gif" width="16" height="16" border="0" /></s:a>
                </td>
            </tr>
            </s:iterator>
        </table>

    <!-- 分页开始 -->
        <table id="page-table" cellspacing="0" align="center">
            <tr>
                <td align="center" nowrap="true">
                    <s:a href="javascript:gotoAction(1,%{pageSize})">首页</s:a>
                    <s:a href="javascript:gotoAction(%{pageBean.prePage},%{pageSize})">上一页&nbsp;&nbsp;</s:a>
                    <s:a href="javascript:gotoAction(%{pageBean.nextPage},%{pageSize})">下一页&nbsp;&nbsp;</s:a>
                    <s:a href="javascript:gotoAction(%{pageBean.totalPage},%{pageSize})">尾页&nbsp;&nbsp;</s:a>
					当前第<s:property value="%{currentPage}"/>页&nbsp;&nbsp;
					共<s:property value="%{pageBean.totalPage}"/>页&nbsp;&nbsp;
					每页显示<s:select name="pageSize" list="{2,4,6,8,10}" onchange="gotoAction(1,this.value)"></s:select>条&nbsp;&nbsp;
					<s:textfield size="4" name="currentPage" id="toPage"></s:textfield>
					<s:a href="javascript:gotoPage(%{pageSize})">转到该页</s:a>
				</td>
            </tr>
        </table>
    <!-- 分页结束 -->
    </div>
</form>

<div id="footer">
	dreamer is doer
</div>
<script type="text/javascript">
	function gotoAction(currentPage, pageSize){
		var form = document.forms["searchForm"];
		document.getElementById("currentPage").value = currentPage;
		document.getElementById("pageSize").value = pageSize;
		form.submit();		
	}
	
	function gotoPage(pageSize){
		var currentPage = document.getElementById("toPage").value;
		gotoAction(currentPage, pageSize);
	}
</script>
</body>
</html>