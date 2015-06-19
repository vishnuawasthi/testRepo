/**	
 * 
 */
package com.ziffi.rest.provider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.valuelabs.test.NumberNotFoundException;
import com.ziffi.entity.Employee;
import com.ziffi.entity.LoginResponse;
import com.ziffi.exception.RecordNotFoundException;
import com.ziffi.form.LoginForm;

/**
 * @author vawasthi
 *
 */
@RestController
public class RestServiceProvider {
	@Autowired
	@Qualifier("objectMapper")
	private ObjectMapper objectMapper;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = { "application/json" }, produces = { "application/json" })
	public @ResponseBody String login(@RequestBody LoginForm loginForm) {
		LoginResponse loginResponse = null;
		String response = null;
		try {
			if (loginForm.getUsername().equals("RAVI")) {
				loginResponse = new LoginResponse("success", "");
			} else {
				loginResponse = new LoginResponse("", "Not Found");
			}
			response = objectMapper.writeValueAsString(loginResponse);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Object> getAllEmployee(@PathVariable("id") String id) throws RecordNotFoundException {
		System.out.println("getAllEmployee  - start  ");
		List<Object> employeeList = new ArrayList<Object>();
		if ("10".equals(id)) {
			Employee employee1 = new com.ziffi.entity.Employee("10", "Denish", "SD");
			employee1.setSuccess("FOUND");
			employeeList.add(employee1);
			System.out.println("getAllEmployee  - success - end ");
			return new ResponseEntity<Object>(employeeList, HttpStatus.OK);
		} else {
			System.out.println("getAllEmployee  - exception - end ");
			// return new ResponseEntity<Object>(new
			// RecordNotFoundException("Not found"), HttpStatus.NOT_FOUND);
			// return new ResponseEntity<Object>("Not found",
			// HttpStatus.NOT_FOUND);
			throw new RecordNotFoundException();
		}
	}

	@ExceptionHandler(value = { RecordNotFoundException.class })
	public @ResponseBody ResponseEntity<RecordNotFoundException> getAllException() {
		System.out.println(" getAllException - start");
		return new ResponseEntity<RecordNotFoundException>(new RecordNotFoundException("Record not found"), HttpStatus.NOT_FOUND);
	}

}
