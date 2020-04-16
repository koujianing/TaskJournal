package com.kjn.TaskJournal.service;

import com.kjn.TaskJournal.model.Task;

import java.util.List;

/**
 * Created by Koujianing
 * Date: 2020/4/14
 * Time: 22:58
 */
public interface TaskService {
	public Task getTaskById(long taskId);
	public List<Task> getTask();
	public void postTask(Task task);
	public void putTask(Task task);
}
