package com.kjn.TaskJournal.service.impl;

import com.kjn.TaskJournal.model.Task;
import com.kjn.TaskJournal.repository.TaskMapper;
import com.kjn.TaskJournal.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public void postTask(Task task){
		taskMapper.insertTask(task);
	}
	@Override
	public void putTask(Task task){
		taskMapper.updateTask(task);
	}
}
