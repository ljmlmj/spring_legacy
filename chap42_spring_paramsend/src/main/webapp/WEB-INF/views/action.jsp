<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
	<title>form param transfer</title>
</head>
<body>
param1 : ${param1 }<br>	<!-- model.addAttribute -->
param2 : ${param2 }<br>	<!-- request.setAttribute -->
param3 : ${param3 }<br>	<!-- map -->
param4 : ${param4 }<br>	<!-- RequestBody : 한글 처리 잘 안됨 -->
param5 : ${param5.name }<br>	<!-- VO(POJO) : member -->
<%-- param6 : ${memberVo.name }<br>	<!-- 커맨드객체 --> --%>
param7 : ${member.name }
</body>
</html>
