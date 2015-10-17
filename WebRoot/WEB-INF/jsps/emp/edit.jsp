<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CRM 管理中心 - 添加/编辑员工 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="./Styles/general.css" rel="stylesheet" type="text/css" />
<link href="./Styles/main.css" rel="stylesheet" type="text/css" />
<!-- 引入时间控件js -->
<script language="javascript" type="text/javascript" src="${path }/My97DatePicker/WdatePicker.js"></script>

</head>
<body>
<h1>
    <span class="action-span"><a href="${path }/emp_list.action">员工列表</a>
    </span>
    <span class="action-span1"><a href="${path }/main_index.action">ECSHOP 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 添加/修改员工信息 </span>
    <div style="clear:both"></div>
</h1>

<div class="tab-div">
    <div id="tabbar-div">
    </div>
    <div id="tabbody-div">
        <form action="#" method="post">
            <table width="90%" id="general-table" align="center">
            	<s:hidden name="employee.id" id="employee.id"></s:hidden>
            	<s:hidden name="employee.loginTime"></s:hidden>
            	<s:hidden name="employee.lastLoginTime"></s:hidden>
            	<s:hidden name="employee.loginIp"></s:hidden>
            	<s:hidden name="employee.lastLoginIp"></s:hidden>
                <tr>
                    <td class="label">姓名：</td>
                    <td><s:textfield name="employee.empName" size="40"></s:textfield></td>
                </tr>
                <tr>
                    <td class="label">密码：</td>
                    <td><s:password name="employee.pwd" showPassword="true" size="40"></s:password></td>
                </tr>
                <tr>
                    <td class="label">性别：</td>
                    <td><s:radio name="employee.sex" list="{'男','女'}"></s:radio></td>
                </tr>
                <tr>
                    <td class="label">电话：</td>
                    <td><s:textfield name="employee.phone" size="40"></s:textfield></td>
                </tr>
                <tr>
                    <td class="label">生日：</td>
                    <td>
                    	<s:date name="employee.birth" format="yyyy-MM-dd" var="birth"/>
                    	<s:textfield name="employee.birth" value="%{#birth}" onclick="WdatePicker()" size="40"></s:textfield>
                    </td>
                </tr>
                <tr>
                    <td class="label">邮箱：</td>
                    <td><s:textfield name="employee.email" size="40"></s:textfield></td>
                </tr>
                <tr>
                    <td class="label">部门：</td>
                    <td><s:select name="employee.dept.id" headerKey="-1" headerValue="--请选择--" list="#deptList" listKey="id" listValue="deptName"></s:select></td>
                </tr>
               
            </table>
            <div class="button-div">
                <input type="button" value=" 确定 " class="button" onclick="form_submit()"/>
                <input type="reset" value=" 重置 " class="button" />
            </div>
        </form>
    </div>
</div>

<div id="footer">
	dreamer is doer
</div>

<script type="text/javascript">
	function form_submit(){
		var form = document.forms[0];
		var id = document.getElementById("employee.id").value;
		if(id != null && id != ''){
			form.action="${path}/emp_update.action";
		}else{
			form.action="${path}/emp_save.action";
		}
		form.submit();
	}
</script>
</body>
</html>