<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- JSTL 标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- 简化书写 -->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="curl" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}" />
<c:set var="url" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}" />
<!-- Ztreev3.5 -->
<link href="${ctx}/js/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/js/Font-Awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/js/bootstraptable/bootstrap-table.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/js/kendo/styles/kendo.common-bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/js/kendo/styles/kendo.bootstrap.min.css" rel="stylesheet" type="text/css"/>

<style>
body,button, input, select, textarea,h1 ,h2, h3, h4, h5, h6 { font-family: Microsoft YaHei,'宋体' , Tahoma, Helvetica, Arial, "\5b8b\4f53", sans-serif;}
</style>
<script src="${ctx}/js/jquery/jquery.min.js" type="text/javascript"></script>
<script src="${ctx}/js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/js/bootstraptable/bootstrap-table.min.js" type="text/javascript"></script>
<script src="${ctx}/js/bootstraptable/bootstrap-table-locale-all.min.js" type="text/javascript"></script>
<script src="${ctx}/js/kendo/js/kendo.all.min.js" type="text/javascript"></script>
<script src="${ctx}/js/kendo/js/cultures/kendo.culture.zh-CN.min.js" type="text/javascript"></script>
<script src="${ctx}/js/kendo/js/messages/kendo.messages.zh-CN.min.js" type="text/javascript"></script>
<script>  
    kendo.culture("zh-CN");
</script> 
