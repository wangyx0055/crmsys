<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CRM 管理中心 - 跟进记录管理 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="./Styles/general.css" rel="stylesheet" type="text/css" />
<link href="./Styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>
    <span class="action-span"><a href="${path }/trace_toEdit.action">添加跟进记录</a></span>
    <span class="action-span1"><a href="${path }/main_index.action">CRM 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 跟进记录管理  </span>
    <div style="clear:both"></div>
</h1>


<!-- 客户列表 -->
<form method="post" action="" name="listForm" onsubmit="">
    <div class="list-div" id="listDiv">
        <table cellpadding="3" cellspacing="1">
            <tr>
                <th>编号</th>
                <th>客户姓名</th>
                <th>跟进者姓名</th>
                <th>跟进时间</th>
                <th>跟进方法</th>
                <th>内容</th>
                <th>跟进结果</th>
            </tr>
            <s:iterator value="#traceHistoryList">
            <tr>
                <td align="center"><s:property value="id"/></td>
                <td align="center" class="first-cell"><s:property value="customer.name"/></td>
                <td align="center"><s:property value="employee.empName"/></td>
                <td align="center"><s:date name="traceTime" format="yyyy-MM-dd HH:mm:ss"/></td>
                <td align="center"><s:property value="traceMethod"/></td>
                <td align="center"><s:property value="content"/></td>
                <td align="center">
              		<s:if test="result == 0">
              			优
              		</s:if>
              		<s:elseif test="result == 1">
              			良
              		</s:elseif>
              		<s:else>
              			差
              		</s:else>
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