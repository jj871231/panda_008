<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="cn.com.trueway.base.util.*"%>

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
<link href="${ctx}/js/bootstraptable/bootstrap-table.min.css" rel="stylesheet" type="text/css"/>

<script src="${ctx}/js/jquery/jquery.min.js" type="text/javascript"></script>
<script src="${ctx}/js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/js/bootstrapvalidator/js/bootstrapValidator.min.js" type="text/javascript"></script>
<script src="${ctx}/js/bootstraptable/bootstrap-table.min.js" type="text/javascript"></script>
<script src="${ctx}/js/bootstraptable/bootstrap-table-locale-all.min.js" type="text/javascript"></script>
