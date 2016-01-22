<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}/" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<c:forEach items="${userList }" var="n">
<li>${n.name }&nbsp;&nbsp;&nbsp;${n.content }</li>

</c:forEach>
</ul>
<form action="${ctx }userController/saveUser" method="post">
姓名：<input type="text" name="name">
描述：<textarea name="content"></textarea>
<input type="submit" value="提交">
</form>
</body>
</html>