
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<script>
$(document).ready(function(){
	validate();
	var form = $("#testForm");
	$(form).keypress(function(){
		if($(form).valid()!=true){
			$("#submit").attr("disabled",true);
		}else{
			$("#submit").attr("disabled",false);
		}
	});
});

</script>
<form:form action="validationTest"   id="testForm"  commandName="testForm" modelAttribute="testForm"  onkeypress="" id="testForm" novalidate="novalidate">
    <h2>User Registration</h2>
    <div id="form-content">
        <fieldset>
            <div class="fieldgroup">
                <label for="firstname">First Name</label>
                <input type="text" name="firstname"  onclick="validate()" /><br/>
            </div>
 
            <div class="fieldgroup">
                <label for="lastname">Last Name</label>
                <input type="text" name="lastname"  onclick="test()" /><br/>
            </div>
 			<div class="fieldgroup">
                <label for="username">User name</label>
                <input type="text" name="username"  id="username"  /><br/>
            </div>
            <div class="fieldgroup">
                <label for="email">Email</label>
                <input type="text" name="email"/><br/>
            </div>
		  <div class="fieldgroup">
                <label for="phone">Phone</label>
                <input type="text" name="phone"/><br/>
            </div>
            <div class="fieldgroup">
                <label for="password">Password</label>
                <input type="password" name="password"  id="password" /> <br/>
            </div>
              <div class="fieldgroup">
                <label for="confirmPassword">Confirm Password</label>
                <input type="password" name="confirmPassword"/><br/>
            </div>
            
            <div class="fieldgroup">
                <p class="right">By clicking register you agree to our <a target="_blank" href="/policy">policy</a>.</p>
                <input type="submit"  id="submit"  value="Register" class="submit"/>
            </div>
        </fieldset>
    </div>
        <div class="fieldgroup">
            <p>Already registered? <a href="/login">Sign in</a>.</p>
        </div>


</form:form>
