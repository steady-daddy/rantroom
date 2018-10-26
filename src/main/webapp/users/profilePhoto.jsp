<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Upload File</title>
</head>
<body>
  <c:url value="/upload" var="upload" />
  <c:url value="/file" var="filePath" />
	
  <form action="${upload}" enctype="multipart/form-data"	method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
    Select Photo: <input type="file" accept="image/*" name="file" /> 
    <input type="submit" value="upload" />
  </form>
  <br>
  <img src="${filePath}" height="100" width="100">

</body>
</html>