<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
  <head>
    <title>logs.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="${path}/front/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
    	window.parent.location.href='${path}/back/login.jsp';
    </script>

  </head>
  
  <body>

  </body>
</html>
