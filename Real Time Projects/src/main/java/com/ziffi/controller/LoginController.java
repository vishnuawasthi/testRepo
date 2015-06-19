/**
 * 
 */
package com.ziffi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ziffi.constants.ZiffiConstants;
import com.ziffi.form.TestForm;
import com.ziffi.util.ZiffiGenericUtils;

/**
 * @author vawasthi
 * 
 */
@Controller
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	
	@Autowired
	@Qualifier(value="ziffiGenericUtils")
	private ZiffiGenericUtils ziffiGenericUtils;

	@RequestMapping(value = ZiffiConstants.LOGIN_URI,method=RequestMethod.GET)
	public ModelAndView showLogin() {
		ziffiGenericUtils.doLogging(logger, "show", true);
		
		ziffiGenericUtils.doLogging(logger, "show", false);
		return new ModelAndView(ZiffiConstants.LOGIN_VIEW);
	}
	
	@RequestMapping(value="/test")
	public ModelAndView showValidations(ModelMap modelMap){
		System.out.println("showValidations - start");
		modelMap.put("testForm", new TestForm());
		
		System.out.println("showValidations - end");
		return new ModelAndView("test",modelMap);
		
	}
	@RequestMapping(value="/validationTest")
	public ModelAndView testSubmit(@ModelAttribute("testForm") @Valid TestForm testForm,BindingResult result,  ModelMap modelMap){
		System.out.println("testSubmit - start");
		
		modelMap.put("testForm", testForm);
		System.out.println("testSubmit - end");
		return new ModelAndView("test",modelMap);
		
	}
	
	/*@RequestMapping(value="/validateUser",method=RequestMethod.POST)
	public String  testUsername(@RequestParam(required=false,value="username") String username ,  ModelMap modelMap){
		System.out.println("testUsername - start");
		
		System.out.println("testUsername - end");
		return new String(username);
		
	}*/
	
	@RequestMapping(value="/validateUser",method=RequestMethod.POST)
	public String  testUsername(@RequestParam(required=false,value="username") String username ,  ModelMap modelMap){
		System.out.println("testUsername - start");
		System.out.println("User name  "+username);
		System.out.println("testUsername - end");
		return "RAVI".equalsIgnoreCase(username)?"RAVI":"This username is already taken. Please enter a different username and try again.";
		
	}
	//profileCheck
	
	@RequestMapping(value="/profileCheck",method=RequestMethod.GET)
	public String  profileCheck(  ModelMap modelMap){
		return "carousel";
}

	@RequestMapping(value="/autoComplete",method={RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody List<String> autoCompleteProvider( @RequestParam("param")  String param,    ModelMap modelMap){
		System.out.println("Param    :  "+param);
		List<String> nameList = new ArrayList<String>(); 
		nameList.add("Ram");
		nameList.add("Jay");
		nameList.add("Pavan");
		nameList.add("Abhinav");
		nameList.add("Sree");
		return nameList;
}


	@RequestMapping(value="/dashboard",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView showDashboard(  ModelMap modelMap){
		return new ModelAndView("dashboard",modelMap);
}
	
	
	//bikeHome
	
	@RequestMapping(value="/bikeHome",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView showbikeHome(  ModelMap modelMap){
		return new ModelAndView("bikeHome",modelMap);
}
}
