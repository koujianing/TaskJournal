package com.kjn.TaskJournal.service.impl;

import java.util.List;
import java.util.ResourceBundle;

import com.github.pagehelper.PageHelper;
import com.kjn.TaskJournal.model.Log;
import com.kjn.TaskJournal.repository.LogMapper;
import com.kjn.TaskJournal.service.LogService;
import com.kjn.TaskJournal.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Koujianing
 * Date: 2020/4/16
 * Time: 21:51
 */
@Service("logService")
public class LogServiceImpl implements LogService {
	@Resource
	private LogMapper logMapper;
//	@Override
//	public List<Log> getLog(){
//		return logMapper.selectLog();
//	}
	@Override
	public List<Log> listLog(int page,int pageSize){
		List<Log> result = null;
		try{
			PageHelper.startPage(page,pageSize);
			PageHelper.orderBy("id ASC");
			result = this.logMapper.selectLog();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public void postLog (Log log) {
		logMapper.insertLog(log);
	}
}
