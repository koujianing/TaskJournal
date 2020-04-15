package com.kjn.TaskJournal.Controller;

import com.kjn.TaskJournal.model.Task;
import com.kjn.TaskJournal.service.TaskService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Koujianing
 * Date: 2020/4/14
 * Time: 23:05
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/task")
public class TaskController {
	//注入mapper类
	@Resource
	private TaskService taskService;
	@RequestMapping(value="{id}",method = RequestMethod.GET,produces = "application/json")
	public Task getTask(@PathVariable long id) throws Exception{
	    Task task = this.taskService.getTaskById(id);
	    return task;
	}
}