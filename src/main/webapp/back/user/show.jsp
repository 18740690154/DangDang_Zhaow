<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/back/css/btn.css" />
	</head>
	<body style="background-color: #f0f9fd;">
		<div align=center style="font-size:25px">用户管理</div><hr/>
		<table bordercolor='#898E90' align='center' border='3px' cellpadding='10px' cellspacing="0px">
			<tr bgcolor='lightblue' align='center'>
				<td>Id</td>
				<td>昵称</td>
				<td>邮箱</td>
				<td>状态</td>
				<td>激活码</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${users}" var="user">
			<tr align='center'>
				<td>${user.id}</td>
				<td>${user.nick_name}</td>
				<td>${user.email}</td>
				<c:if test="${user.status==0}"><td>冻结</td></c:if>
				<c:if test="${user.status==1}"><td>正常</td></c:if>		
				<td>${user.cdkey}</td>
				<td>
					<input class="button" onclick="location.href='${pageContext.request.contextPath}/user/update?user.id=${user.id}'" value="修改 &raquo;" />
				</td>
			</tr>
			</c:forEach>
			
			 
			
		</table>
	</body>  
</html>



