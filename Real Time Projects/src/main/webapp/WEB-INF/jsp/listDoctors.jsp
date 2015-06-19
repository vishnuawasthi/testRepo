<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table>
	<c:if test="${not empty profileList }">
		<c:forEach items="${profileList }" var="doctor">
			<tr>
				<td><img alt="Image not found"
					src="<c:url value='${doctor.photoPath}'/>" width="40px"
					height="40px" /></td>
				<td>${doctor.firstName}&nbsp; ${doctor.lastName}</td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty profileList }">
		<tr>
			<td colspan="5" style="color: red;">Data does not exist.</td>
		</tr>
	</c:if>
</table>