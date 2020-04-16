package com.kjn.TaskJournal.Controller;

import com.kjn.TaskJournal.model.Log;
import com.kjn.TaskJournal.repository.LogMapper;
import com.kjn.TaskJournal.service.LogService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Koujianing
 * Date: 2020/4/16
 * Time: 21:50
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/log")
public class LogController {
	@Resource
	private LogService logService;

	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public void postLog(Log log){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.setTime(df.format(new Date()));
		System.out.println(log.toString());
		this.logService.postLog(log);
	}

}
