<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="cn.com.trueway.base.util.*"%>

<!-- JSTL 标签 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- 简化书写 -->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="curl" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}" />



