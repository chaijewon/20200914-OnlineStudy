<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="won" value="20000"/>
<c:set var="data" value="Hello Java"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <fmt:formatNumber value="${won }" pattern="00,000"/>
  <br>
  ${fn:toUpperCase(data) }<br>
  ${fn:toLowerCase(data) }
</body>
</html>