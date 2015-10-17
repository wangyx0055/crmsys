<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
	pageContext.setAttribute("path", request.getContextPath());
 %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>CRM管理中心</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/Javascript" language="JavaScript">

if (window.top != window) {
    window.top.location.href = document.location.href;
}
</script>
</head>
<frameset rows="76,*" framespacing="0" border="0">
    <frame src="${path }/main_top.action" id="header-frame" name="header-frame" frameborder="no" scrolling="no">
    <frameset cols="180,*" framespacing="0" border="0" id="frame-body">
        <frame src="${path }/main_menu.action" id="menu-frame" name="menu-frame" frameborder="no">
        <frame src="${path }/main_index.action" id="main-frame" name="main-frame" frameborder="no">
    </frameset>
</frameset>
</html>