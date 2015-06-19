/**
 * 
 */
package com.ziffi.controller;

import java.util.List;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



/**
 * @author vawasthi
 *
 */
@Controller
public class RestClientController {
	@RequestMapping(value="/restTest" ,method=RequestMethod.GET)
	public ModelAndView restTest(ModelMap modelMap,HttpRequest request){
		List employeeList = null;
		modelMap.put("employeeList", employeeList);
		return new ModelAndView("restTest", modelMap);
	}

}
