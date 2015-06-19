<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <!-- Load jQuery and the validate plugin -->
 <!--  <script src="//code.jquery.com/jquery-1.9.1.js"></script>
  <script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script> -->
  
  <!--   JQUERY validation js -->
  
 <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script> 
<script type="text/javascript" src="<c:url value='/script/common.js' />"></script>
<%-- <script type="text/javascript" src="<c:url value='/script/jquery.validate.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/script/jquery-1.11.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/script/additional-methods.min.js' />"></script> --%>
<!--  Boot strap -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> -->
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<link href="<c:url value='/css/style.css' />" rel="stylesheet" type="text/css">
	
<title>Ziffi</title>
</head>
<body>
	<%@include file="/WEB-INF/jsp/template/header.jsp"%>
	<%@include file="/WEB-INF/jsp/template/navigationTop.jsp"%>
<hr>
	<decorator:body>
	</decorator:body>
	<hr>
	<h1>Master Page</h1>
	<%@include file="/WEB-INF/jsp/template/footer.jsp"%>

</body>
</html>