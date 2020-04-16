package com.kjn.TaskJournal.service.impl;

import java.util.ResourceBundle;

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

	@Override
	public void postLog (Log log) {
		logMapper.insertLog(log);
	}
}
