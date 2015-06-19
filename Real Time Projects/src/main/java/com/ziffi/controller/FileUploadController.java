/**
 * 
 */
package com.ziffi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ziffi.entity.Media;
import com.ziffi.service.impl.HibernateOperationsService;
import com.ziffi.util.ZiffiGenericUtils;



/**
 * @author vawasthi
 *
 */
@Controller
public class FileUploadController {

	private static final Logger logger = Logger.getLogger(FileUploadController.class);
	
	@Autowired
	private HibernateOperationsService hibernateOperationsService;

	
	@Autowired
	private ZiffiGenericUtils  zffiGenericUtils ;
	
	@RequestMapping(value="/video",method=RequestMethod.GET)
	public ModelAndView showVideoUpload(ModelMap modelMap){
		return new ModelAndView("videoupload", modelMap);
	}
	@RequestMapping(value="/uploadVideo",method=RequestMethod.POST)
	public ModelAndView uploadVideo( @RequestParam("video") MultipartFile videoFile,ModelMap modelMap ,HttpServletRequest request){
		zffiGenericUtils.doLogging(logger, "uploadVideo", true);
		try{
			String fileName  =	zffiGenericUtils.createFile(videoFile, request,"VIDEO");
			Media media = new Media();
			media.setName(fileName);
			media.setPath("/videos/"+fileName);
			hibernateOperationsService.save(media);
			List <Media> mediaList = hibernateOperationsService.list();
			modelMap.put("mediaList", mediaList);
		}catch(IOException e){
			logger.error("FileUploadController  : uploadVideo "+e);
		}
		zffiGenericUtils.doLogging(logger, "uploadVideo", false);
		return new ModelAndView("videoupload", modelMap);
	}
}

