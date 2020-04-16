package com.kjn.TaskJournal.Controller;

import com.kjn.TaskJournal.model.Task;
import com.kjn.TaskJournal.service.TaskService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import java.util.Date;
import java.text.SimpleDateFormat;

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

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	public Task getTask (@PathVariable long id) throws Exception {
		Task task = this.taskService.getTaskById(id);
		return task;
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public List<Task> getAllTask () throws Exception {
		List<Task> task = this.taskService.getTask();
		return task;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public void postTask (Task task) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		task.setCreated_at(df.format(new Date()));
//		System.out.println(task.toString());
		this.taskService.postTask(task);
	}

	//"" null "null"
	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
	public void putTask (@PathVariable long id, Task task) throws Exception {
		Task oldTask = this.taskService.getTaskById(id);
		task.setId(id);
		Task newTask = oldTask.mixinData(task);
		this.taskService.putTask(newTask);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
	public void deleteTask (@PathVariable long id) throws Exception {
		Task oldTask = this.taskService.getTaskById(id);
		Task task = new Task();
		task.setId(id);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		task.setIs_delete(df.format(new Date()));
		Task newTask = oldTask.mixinData(task);
		this.taskService.putTask(newTask);
	}

//	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
//	public Task getTask (Task task) throws Exception {
//		this.taskService.insert(task);
//		return {"code": 200};
//	}
}