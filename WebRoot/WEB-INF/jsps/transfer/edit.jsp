<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CRM 管理中心 - 添加移交记录 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="./Styles/general.css" rel="stylesheet" type="text/css" />
<link href="./Styles/main.css" rel="stylesheet" type="text/css" />
<!-- 引入时间控件js -->
<script language="javascript" type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
<h1>
    <span class="action-span">
    	<a href="${path }/customer_list.action?condition.transferStatus=0">客户列表</a>
  		<a href="${path }/transfer_list.action">客户移交记录</a>
    </span>
    <span class="action-span1"><a href="${path }/main_index.action">CRM 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 添加移交记录 </span>
    <div style="clear:both"></div>
</h1>

<div class="tab-div">
    <div id="tabbar-div">
    </div>
    <div id="tabbody-div">
        <form action="${path }/transfer_save.action" method="post">
            <table width="90%" id="general-table" align="center">
            	<s:hidden name="transferHistory.employeeOld.id" value="%{#session.loginInfo.id}"></s:hidden>
                <tr>
                	<td class="label">客户姓名：</td>
                	<td>
	                	<s:if test="customer == null">
	                		<s:select name="transferHistory.customer.id" 
	                			list="#customerList" 
	                			headerKey="-1" 
	                			headerValue="--请选择--" 
	                			listKey="id" 
	                			listValue="name">
	                		</s:select>
	                	</s:if>
	                	<s:else>
	                		<td><s:property value="customer.name"></s:property></td>
	                		<s:hidden name="transferHistory.customer.id" value="%{customer.id}"></s:hidden>
	                	</s:else>
	                </td>
                </tr>
                <tr>
                    <td class="label">移交者姓名：</td>
                    <td><s:property value="%{#session.loginInfo.empName}"></s:property></td>
                </tr>
                <tr>
                    <td class="label">接收者姓名：</td>
                    <td>
						<s:select name="transferHistory.employeeNew.id" 
                			list="#empList" 
                			headerKey="-1" 
                			headerValue="--请选择--" 
                			listKey="id" 
                			listValue="empName">
                		</s:select>
					</td>
                </tr>
                <tr>
                    <td class="label">移交时间：</td>
                    <td><s:textfield name="transferHistory.transferTime" onclick="WdatePicker()" size="40"></s:textfield></td>
                </tr>
                <tr>
                    <td class="label">移交原因：</td>
                    <td><s:textarea name="transferHistory.reason" cols="40" rows="5"></s:textarea></td>
                </tr>
               
            </table>
            <div class="button-div">
                <input type="submit" value=" 确定 " class="button"/>
                <input type="reset" value=" 重置 " class="button" />
            </div>
        </form>
    </div>
</div>

<div id="footer">
	dreamer is doer
</div>

</body>
</html>