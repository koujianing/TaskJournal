package com.kjn.TaskJournal.service;

import com.kjn.TaskJournal.model.Log;

import java.util.List;

/**
 * Created by Koujianing
 * Date: 2020/4/16
 * Time: 21:52
 */
public interface LogService {
	public void postLog(Log log);
//	public List<Log> getLog();
	public List<Log> listLog(int page,int pageSize);
}
