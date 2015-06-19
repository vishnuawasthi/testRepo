<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container">
	<div class="well"></div>
	
	<div class="row"><a>
	  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>DEAPARTMENT</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="employeeList" var="employee">
    
      <tr class="success">
        <td>${employee.id }</td>
        <td>${employee.name }</td>
        <td>${employee.dept }</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
	
	
	</a></div>
	
</div>