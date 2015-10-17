<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CRM 管理中心 - 添加/编辑部门 </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="./Styles/general.css" rel="stylesheet" type="text/css" />
<link href="./Styles/main.css" rel="stylesheet" type="text/css" />
</head>
<body>
<h1>
    <span class="action-span"><a href="${path }/dept_list.action">部门列表</a>
    </span>
    <span class="action-span1"><a href="${path }/main_index.action">ECSHOP 管理中心</a></span>
    <span id="search_id" class="action-span1"> - 添加/修改部门信息 </span>
    <div style="clear:both"></div>
</h1>

<div class="tab-div">
    <div id="tabbar-div">
    </div>
    <div id="tabbody-div">
        <form action="#" method="post">
            <table width="90%" id="general-table" align="center">
            	<s:hidden name="dept.id" id="dept.id"></s:hidden>
                <tr>
                    <td class="label">部门名称：</td>
                    <td>
                    	<s:textfield name="dept.deptName" size="40"></s:textfield>
                    </td>
                </tr>
               
                <tr>
                    <td class="label">部门简单描述：</td>
                    <td>
                        <s:textarea name="dept.remarks" cols="40" rows="5"></s:textarea>
                    </td>
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
		var id = document.getElementById("dept.id").value;
		if(id != null && id != ''){
			form.action="${path}/dept_update.action";
		}else{
			form.action="${path}/dept_save.action";
		}
		form.submit();
	}
</script>
</body>
</html>