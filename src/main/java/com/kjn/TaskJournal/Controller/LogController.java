package com.kjn.TaskJournal.Controller;

import com.github.pagehelper.PageInfo;
import com.kjn.TaskJournal.model.Log;
import com.kjn.TaskJournal.repository.LogMapper;
import com.kjn.TaskJournal.service.LogService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
//	@RequestMapping(value = "/all",method = RequestMethod.GET,produces = "application/json")
//	public List<Log> getAllLog(){
//		List<Log> log = this.logService.getLog();
//		return log;
//	}
@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
public PageInfo<Log> listType (
		@RequestParam(value = "page", required = false, defaultValue = "1") int page,
		@RequestParam(value = "count", required = false, defaultValue = "5") int pageSize
) {
	List<Log> result = logService.listLog(page, pageSize);
	PageInfo<Log> pi = new PageInfo<Log>(result);
	return pi;
}
	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public void postLog(Log log){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		log.setTime(df.format(new Date()));
		System.out.println(log.toString());
		this.logService.postLog(log);
	}

}
