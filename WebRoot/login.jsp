<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CRM 管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="__PUBLIC__/Styles/general.css" rel="stylesheet" type="text/css" />
<link href="__PUBLIC__/Styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body style="background: #278296;color:white">
<form method="post" action="" onsubmit="return validate()">
    <table cellspacing="0" cellpadding="0" style="margin-top:100px" align="center">
        <tr>
            <td>
                <img src="Images/login.png" width="178" height="256" style="margin-top:40px;" border="0" alt="CRM" />
            </td>
            <td style="padding-left: 50px">
                <table>
                    <tr>
                        <td>姓名：</td>
                        <td>
                            <input type="text" name="employee.empName" />
                        </td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td>
                            <input type="password" name="employee.pwd" />
                        </td>
                    </tr>
                    <tr>
                    	<td>验证码：</td>
                        <td>
                        	<input type="text" name="code_image" size="6" />
                            <img id="img_code" src="${path }/image_execute.action" style="cursor: hand" title="点我更换!" onclick="change()" />
                        </td>
                    </tr>
                    <tr>
                    	<font color="red">${msg }</font>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td>
                            <input type="submit" value="进入管理中心" class="button" />
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
  <input type="hidden" name="act" value="signin" />
</form>
<script type="text/javascript">
	function validate(){
		var form = document.forms[0];
		form.action = "${path}/login_execute.action";
		form.submit();	
	}
	//点击更换验证码
	function change(){
		var img = document.getElementById('img_code');
		img.src = '${path}/image_execute.action?i_='+new Date().getTime();
	}
</script>
</body>
</html>