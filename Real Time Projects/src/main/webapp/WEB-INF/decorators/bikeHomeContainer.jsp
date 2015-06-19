<!DOCTYPE html>
<%@taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>User Profiler</title>
<!--  Boot strap -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script
	src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>

<!-- CSS and  JS file  -->
<script type="text/javascript" src="<c:url value='/script/common.js' />"></script>
<link href="<c:url value='/css/style.css' />" rel="stylesheet"
	type="text/css">

</head>
<body class="body-color">
<div class="container top-margin">
<%@include file="/WEB-INF/jsp/template/headerBike.jsp"%>
<decorator:body></decorator:body>
</div>
</body>
</html>