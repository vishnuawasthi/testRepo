<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<form:form action="doRegistration" modelAttribute="registrationForm" commandName="registrationForm" id="registrationForm" >
<table>
<tr> <td>First Name : </td> <td><form:input path="firstName"  id="firstName" />   </td> <td> <form:errors path="firstName"></form:errors>     </td>   </tr>
<tr> <td> Last Name : </td> <td><form:input path="lastName"  id="lastName"/>   </td> <td> <form:errors path="lastName"></form:errors>     </td>   </tr>
<tr> <td>  Email  : </td> <td><form:input path="email"  id="email"/>   </td> <td> <form:errors path="email"></form:errors>     </td>   </tr>
<tr> <td> Phone Number : </td> <td><form:input path="phone"  id="phone"/>   </td> <td> <form:errors path="phone"></form:errors>     </td>   </tr>
<tr> <td> Address </td> <td><form:input path="address"  id="address"/>   </td> <td> <form:errors path="address"></form:errors>     </td>   </tr>
<tr> <td>  </td> <td>   <input type="submit" value="Submit" />  </td> <td>     </td>   </tr>

</table>
</form:form>


<script>
// just for the demos, avoids form submit
jQuery.validator.setDefaults({
debug: true,
success: "valid"
});

$("#registrationForm").validate({
rules: {
firstName: "required",
lastName: "required",
email:{ email:true,required:true},
phone: "required",
address: "required"
/* 
password_again: {
equalTo: "#password"
} */
}

});
</script>