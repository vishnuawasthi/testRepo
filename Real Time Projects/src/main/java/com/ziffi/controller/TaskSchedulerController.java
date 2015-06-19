/**
 * 
 */
package com.ziffi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ziffi.entity.Task;
import com.ziffi.form.TaskForm;
import com.ziffi.service.impl.SchedulerService;

/**
 * @author vawasthi
 *
 */
@Controller
public class TaskSchedulerController {

	@Autowired
	private SchedulerService schedulerService;

	@RequestMapping(value = "/task", method = RequestMethod.GET)
	public ModelAndView showCreateTask(ModelMap modelMap, HttpServletRequest request) {
		modelMap.put("taskForm", new TaskForm());
		return new ModelAndView("createTask", modelMap);
	}

	@RequestMapping(value = "/createTask", method = RequestMethod.POST)
	public ModelAndView createTask(@ModelAttribute("taskForm") @Valid TaskForm taskForm, BindingResult result, ModelMap modelMap,
			HttpServletRequest request) {
		boolean errorFlag = true;
		String viewName = "createTask";
		if (result.hasErrors()) {
			modelMap.put("taskForm", taskForm);
			return new ModelAndView(viewName, modelMap);
		}
		Task task = new Task();
		populateTaskEntiyFormForm(taskForm, task);
		try {
			schedulerService.createTask(task);
			viewName = "listTask";
			errorFlag = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelMap.put("taskForm", errorFlag ? taskForm : new TaskForm());
		return new ModelAndView(viewName, modelMap);
	}

	private void populateTaskEntiyFormForm(TaskForm taskForm, Task task) {
		task.setName(taskForm.getName());
		task.setDescription(taskForm.getDescription());
		task.setScheduledTime(taskForm.getScheduledTime());
		task.setEndTime(taskForm.getEndTime());
		task.setStartTime(taskForm.getStartTime());
		task.setDays(taskForm.getDays());
	}

	@RequestMapping(value = { "/listTask", "/list" }, method = RequestMethod.GET)
	public ModelAndView listTask(ModelMap modelMap, HttpServletRequest request) {
		List<Task> taskList = schedulerService.getTaskList();
		modelMap.put("taskList", taskList);
		return new ModelAndView("listTask", modelMap);
	}

}
