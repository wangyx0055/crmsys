<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CRM 管理中心 - 移交记录管理 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="./Styles/general.css" rel="stylesheet" type="text/css" />
<link href="./Styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>
    <span class="action-span"><a href="${path }/transfer_toEdit.action">添加移交记录</a></span>
    <span class="action-span1"><a href="${path }/main_index.action">CRM 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 移交记录管理  </span>
    <div style="clear:both"></div>
</h1>


<!-- 客户列表 -->
<form method="post" action="" name="listForm" onsubmit="">
    <div class="list-div" id="listDiv">
        <table cellpadding="3" cellspacing="1">
            <tr>
                <th>编号</th>
                <th>客户姓名</th>
                <th>移交者姓名</th>
                <th>接收者姓名</th>
                <th>移交原因</th>
                <th>移交时间</th>
            </tr>
            <s:iterator value="#tansferHistoryList">
            <tr>
                <td align="center"><s:property value="id"/></td>
                <td align="center" class="first-cell"><s:property value="customer.name"/></td>
                <td align="center"><s:property value="employeeOld.empName"/></td>
                <td align="center"><s:property value="employeeNew.empName"/></td>
                <td align="center"><s:property value="reason"/></td>
                <td align="center"><s:date name="transferTime" format="yyyy-MM-dd HH:mm:ss"/></td>
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