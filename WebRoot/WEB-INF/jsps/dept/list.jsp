<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CRM 管理中心 - 部门管理 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="./Styles/general.css" rel="stylesheet" type="text/css" />
<link href="./Styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>
    <span class="action-span"><a href="${path }/dept_toEdit.action">添加部门</a></span>
    <span class="action-span1"><a href="${path }/main_index.action">CRM 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 部门管理 </span>
</h1>


<!-- 商品列表 -->
<form method="post" action="" name="listForm" onsubmit="">
    <div class="list-div" id="listDiv">
        <table cellpadding="3" cellspacing="1">
            <tr>
                <th>编号</th>
                <th>部门名称</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            <s:iterator value="#deptList">
            <tr>
                <td align="center"><s:property value="id"/></td>
                <td align="center" class="first-cell"><s:property value="deptName"/></td>
                <td align="center"><s:property value="remarks"/></td>
                <td align="center">
	                <s:a href="dept_toEdit.action?dept.id=%{id}" title="编辑"><img src="./Images/icon_edit.gif" width="16" height="16" border="0" /></s:a>
	                <s:a href="dept_delete.action?dept.id=%{id}" title="删除"><img src="./Images/icon_trash.gif" width="16" height="16" border="0" /></s:a>
                </td>
            </tr>
            </s:iterator>
        </table>
        
    </div>
</form>

<div id="footer">
	dreamer is doer
</div>
</body>
</html>