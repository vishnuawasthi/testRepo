<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="container">
	<form:form role="form">

		<div class="form-group">
			<label for="name"> Task : </label>
			<form:input path="name" class="form-control" id="name" />
		</div>

		<div class="form-group">
			<label for="startTime">Start Time : </label>
			<form:input path="startTime" class="form-control" id="startTime" />
		</div>

		<div class="form-group">
			<label for="endTime">End Time :</label>
			<form:input path="endTime" class="form-control" id="endTime" />
		</div>

		<div class="form-group">
			<label for="days">Scheduled Days :</label>

			<form:checkbox path="days" value="SUNDAY"> </form:checkbox>
			<form:checkbox path="days" value="MONDAY"></form:checkbox>
			<form:checkbox path="days" value="TUESDAY"></form:checkbox>
			<form:checkbox path="days" value="WEDNESDAY"></form:checkbox>
			<form:checkbox path="days" value="THRUSDAY"></form:checkbox>
			<form:checkbox path="days" value="FRIDAY"></form:checkbox>
			<form:checkbox path="days" value="SATURDAY"></form:checkbox>

		</div>

		<div class="form-group">
			<label for="email">Email address:</label> <input type="email"
				class="form-control" id="email">
		</div>

		<div class="form-group">
			<label for="email">Email address:</label> <input type="email"
				class="form-control" id="email">
		</div>


	</form:form>


</div>