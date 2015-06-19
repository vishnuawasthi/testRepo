<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<h1><spring:message code="label.welcome" />    Dear, You can watch this video. </h1>



<form action="uploadVideo"   enctype="multipart/form-data"   method="POST">
<input type="file"  name="video" >
<input type="submit" value="Submit">
</form>

<c:forEach  items="${mediaList }" var="media">
<video width="320" height="240" controls>
  <source src="${media.path}" type="video/x-ms-wmv">
 <!--  <source src="movie.ogg" type="video/ogg"> -->
  Your browser does not support the video tag.
</video>
</c:forEach>