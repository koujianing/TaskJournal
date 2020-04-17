package com.kjn.TaskJournal.repository;

import com.kjn.TaskJournal.model.Log;

import java.util.List;

/**
 * Created by Koujianing
 * Date: 2020/4/16
 * Time: 21:51
 */
public interface LogMapper {
//	List<Log> selectLog();
	List<Log> selectLog();
	void insertLog(Log log);
}
