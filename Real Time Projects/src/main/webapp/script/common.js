function isValidEmailAddress(emailAddress) {
	var pattern = new RegExp(
			/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i);
	return pattern.test(emailAddress);
};

$.validator.addMethod('customphone', function(value, element) {
	return this.optional(element) || /^\d{3}-\d{3}-\d{4}$/.test(value);
}, "Please enter a valid phone number");

function validate() {
	// Setup form validation on the #register-form element
	$("#testForm").validate({
		// Specify the validation rules
		rules : {
			firstname : "required",
			lastname : "required",
			email : {
				required : true,
				email : true
			},
			username : {
				required : true,
				/*remote : {
					url : "validateUser",
					type : "post",
					data : {
						username: function() {
						return $( "#username" ).val();
						}
					}
				}*/
			},
			password : {
				required : true,
				minlength : 5
			},
			confirmPassword : {
				equalTo : "#password"
			},
			agree : "required",
			test : "customphone"
		},

		// Specify the validation error messages
		messages : {
			firstname : "Please enter your first name",
			lastname : "Please enter your last name",
			password : {
				required : "Please provide a password",
				minlength : "Your password must be at least 5 characters long"
			},

			confirmPassword : "Confirm password did not match",

			email : "Please enter a valid email address",
			agree : "Please accept our policy",
			username:{
				required  : "Please enter username",
				remote : "This username has been taken already.Please try another"
			}
		},

		/**
		 * This handler submits the form if it is an valid form.
		 */
		submitHandler : function(form) {
			form.submit();
		},
		/**
		 * This handler will invoke  every time when form is invalid.
		 */
		invalidHandler : function(event, validator) {
			//alert('Form contains errors and cannot be submitted.');
			// you don't need this handler, it's just here for demo
		}

	});
}

/*
 * Phone validataions Java regular expression. // String expression =
 * "^\\(?(\\d{3})\\)?[-. ]?(\\d{3})[-. ]?(\\d{4})$";
 */

function phonenumber(inputtxt) {
	var phoneno = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
	if (inputtxt.value.match(phoneno)) {
		alert("in success");
		return true;
	} else {
		alert("message");
		return false;
	}
}