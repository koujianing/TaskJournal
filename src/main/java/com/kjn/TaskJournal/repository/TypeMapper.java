package com.kjn.TaskJournal.repository;

import com.kjn.TaskJournal.model.Task;
import com.kjn.TaskJournal.model.Type;

import java.util.List;

/**
 * Created by Koujianing
 * Date: 2020/4/15
 * Time: 22:16
 */
public interface TypeMapper {
	List<Type> selectType();
//	List<Task> selectTask();
}
