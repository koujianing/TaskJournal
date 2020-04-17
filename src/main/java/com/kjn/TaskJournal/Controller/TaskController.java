package com.kjn.TaskJournal.Controller;

import com.github.pagehelper.PageInfo;
import com.kjn.TaskJournal.model.Log;
import com.kjn.TaskJournal.model.Task;
import com.kjn.TaskJournal.service.LogService;
import com.kjn.TaskJournal.service.TaskService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

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

	@Resource
	private LogService logService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	public Task getTask (@PathVariable long id) throws Exception {
		Task task = this.taskService.getTaskById(id);
		return task;
	}

	/**
	 * Pagehelper 返回数据格式
	 * {
	 * "total": 7,                    // 所有的数据数量
	 * "list": [],                    // 返回的数据
	 * "pageNum": 2,                  // 当前的页码
	 * "pageSize": 2,                 // 每一页的数据数量
	 * "size": 2,                     // 搜索出来的数据数量
	 * "startRow": 3,                 // 开始的id
	 * "endRow": 4,                   // 结束的id
	 * "pages": 4,                    // 总页数
	 * "prePage": 1,                  // 前一页的页码
	 * "nextPage": 3,                 // 后一页的页码
	 * "isFirstPage": false,          // 是否是第一页
	 * "isLastPage": false,           // 是否是最后一页
	 * "hasPreviousPage": true,       // 是否有前一页
	 * "hasNextPage": true,           // 是否有后一页
	 * "navigatePages": 8,
	 * "navigatepageNums": [
	 * 1,
	 * 2,
	 * 3,
	 * 4
	 * ],
	 * "navigateFirstPage": 1,
	 * "navigateLastPage": 4
	 * }
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<Task> getAllTask () throws Exception {
		List<Task> task = this.taskService.getTask();
		return task;
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public PageInfo<Task> listTask (
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "count", required = false, defaultValue = "5") int pageSize
	) {
		List<Task> result = this.taskService.listTask(page, pageSize);
		PageInfo<Task> pi = new PageInfo<Task>(result);
		return pi;
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
		Task oldTask = this.taskService.getTaskById(id);//通过id把数据库那一行的数据赋给oldTask
		long oldStatus = oldTask.getStatus();//
		task.setId(id);//id赋给task.id
		Task newTask = oldTask.mixinData(task);//可以单个修改
		this.taskService.putTask(newTask);

		// 判断是否修改了status字段
		// 如果修改了 调用insertLog方法
		if (oldStatus != newTask.getStatus()) {
			Log log = new Log();
			log.setTask_id(newTask.getId());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			log.setTime(df.format(new Date()));
			log.setStatus(newTask.getStatus());
			log.setOld_status(oldStatus);
//			System.out.println(log.toString());
			this.logService.postLog(log);
		}
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