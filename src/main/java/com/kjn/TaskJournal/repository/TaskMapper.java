package com.kjn.TaskJournal.repository;

import com.kjn.TaskJournal.model.Task;

import java.util.List;

/**
 * Created by Koujianing
 * Date: 2020/4/14
 * Time: 23:06
 */
public interface TaskMapper {
	Task selectByPrimaryKey (long id);
	List<Task> selectTask();
	void insertTask(Task task);
	void updateTask(Task task);
}
