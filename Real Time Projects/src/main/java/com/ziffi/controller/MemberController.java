/**
 * 
 */
package com.ziffi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ziffi.entity.Profile;
import com.ziffi.form.DoctorsMembershipForm;
import com.ziffi.form.RegistrationForm;
import com.ziffi.service.impl.HibernateOperationsService;
import com.ziffi.util.ZiffiGenericUtils;

/**
 * @author vawasthi
 * 
 */
@Controller
public class MemberController {
	private static final Logger logger = Logger.getLogger(MemberController.class);

	public static final String PROILE_URI = "/loadProfile";

	public static final String SAVE_PROILE_URI = "/saveProfile";

	public static final String PROFILE_VIEW = "profile";

	private static final String DOCTOR_PRIFILE_FORM = "doctorsMembershipForm";

	@Autowired
	@Qualifier(value = "ziffiGenericUtils")
	private ZiffiGenericUtils ziffiGenericUtils;
	
	@Autowired
	private HibernateOperationsService hibernateOperationsService;

	@RequestMapping(value = PROILE_URI, method = RequestMethod.GET)
	public ModelAndView showProfile(ModelMap modelMap) {
		ziffiGenericUtils.doLogging(logger, "showProfile", true);
		modelMap.put("doctorsMembershipForm", new DoctorsMembershipForm());
		ziffiGenericUtils.doLogging(logger, "showProfile", false);
		return new ModelAndView(PROFILE_VIEW);
	}

	@RequestMapping(value = SAVE_PROILE_URI, method = RequestMethod.POST)
	public ModelAndView saveProfile(@ModelAttribute(DOCTOR_PRIFILE_FORM) @Valid DoctorsMembershipForm doctorsMembershipForm, BindingResult result,
			@RequestParam(required = false, value = "file") MultipartFile file, ModelMap modelMap, HttpServletRequest request) {
		ziffiGenericUtils.doLogging(logger, "saveProfile", true);
	
		if (StringUtils.isEmpty(file)) {
			result.addError(new FieldError(DOCTOR_PRIFILE_FORM, "displayPicture", "Please select a file"));
		}
		try {
			if (result.hasErrors()) {
				modelMap.put(DOCTOR_PRIFILE_FORM, doctorsMembershipForm);
				logger.error("saveProfile   : Field validation error ");
				return new ModelAndView(PROFILE_VIEW, modelMap);
			}
			com.ziffi.entity.Profile profile = new com.ziffi.entity.Profile();
			profile.setFirstName("test1"); 
			profile.setCity("Bhopal");
			String fileName = ziffiGenericUtils.createFile(file, request,"IMAGE");	
			profile.setPhotoPath("/uploadedImages/"+fileName);
			hibernateOperationsService.save(profile);
			modelMap.put("rootPath", "/uploadedImages/" + fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		modelMap.put(DOCTOR_PRIFILE_FORM, new DoctorsMembershipForm());
		ziffiGenericUtils.doLogging(logger, "saveProfile", false);
		return new ModelAndView(PROFILE_VIEW, modelMap);
	}
	
	@SuppressWarnings(value="unchecked")
	@RequestMapping(value = "/listDoctors", method = RequestMethod.GET)
	public ModelAndView saveProfile(ModelMap modelMap) {
		List<Profile> profileList = hibernateOperationsService.list();
		modelMap.put("profileList", profileList);
		return new ModelAndView("listDoctors", modelMap);
	}
	
	@RequestMapping(value="/loadRegistration",method=RequestMethod.GET)
	public ModelAndView showRegistration(ModelMap modelMap){
		modelMap.put("registrationForm", new RegistrationForm());
		return new ModelAndView("formRegistration", modelMap);
	}
	
	@RequestMapping(value="/doRegistration",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView doRegistration(@ModelAttribute("registrationForm") @Valid RegistrationForm registrationForm,BindingResult result  ,ModelMap modelMap){
		if(result.hasErrors()){
			return new ModelAndView("formRegistration", modelMap);
		}
		modelMap.put("registrationForm", new RegistrationForm());
		return new ModelAndView("formRegistration", modelMap);
	}
	
	
}
