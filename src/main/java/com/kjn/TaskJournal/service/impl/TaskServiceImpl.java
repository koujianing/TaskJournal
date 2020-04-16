package com.kjn.TaskJournal.service.impl;

import com.kjn.TaskJournal.model.Task;
import com.kjn.TaskJournal.repository.TaskMapper;
import com.kjn.TaskJournal.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import com.github.pagehelper.PageHelper;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Koujianing
 * Date: 2020/4/14
 * Time: 23:01
 */
@Service("taskService")
public class TaskServiceImpl implements TaskService {

	@Resource
	private TaskMapper taskMapper;
	@Override
	public Task getTaskById(long taskId){
		return taskMapper.selectByPrimaryKey(taskId);
	}
//	selectTask
	@Override
	public List<Task> getTask(){
	return taskMapper.selectTask();
}
	@Override
	public List<Task> listTask(int page,int pageSize){
		List<Task> result = null;
		try {
			// 调用pagehelper分页，采用starPage方式。starPage应放在Mapper查询函数之前
			PageHelper.startPage(page, pageSize); //每页的大小为pageSize，查询第page页的结果
			PageHelper.orderBy("id ASC "); //进行分页结果的排序
			result = taskMapper.selectTask();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	@Override
	public void postTask(Task task){
		taskMapper.insertTask(task);
	}
	@Override
	public void putTask(Task task){
		taskMapper.updateTask(task);
	}
}
