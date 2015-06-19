<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>Profile</h1>
<img src="<c:url value='/uploadedImages/download.jpg' />"
	alt="Image not found" />



<form:form action="saveProfile" modelAttribute="doctorsMembershipForm"
	commandName="doctorsMembershipForm" enctype="multipart/form-data" >
	<table>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>Select display picture</td>
			<td> <%-- <form:input  type="file" path="displayPicture"></form:input>  --%>
			<input  type="file"  name="file"  /> 
			   </td>
			<td > ${rootPath}   <form:errors path="displayPicture" cssClass="fieldErrors"></form:errors> </td>
		</tr>
		<tr>
			<td>   <img alt="Image not found" src="<c:url value='${rootPath}'/> ">     </td>
			<td><input type="submit" value="Submit" /></td>
			<td></td>
		</tr>


	</table>
	<a href="listDoctors"> Click here to list Doctors</a>
</form:form>
