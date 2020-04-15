package com.kjn.TaskJournal.Controller;

import com.kjn.TaskJournal.model.Task;
import com.kjn.TaskJournal.model.Type;
import com.kjn.TaskJournal.service.TypeService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Koujianing
 * Date: 2020/4/15
 * Time: 22:23
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/type")
public class TypeController {
	@Resource
	private TypeService typeService;
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public List<Type> getAllType () throws Exception {
		List<Type> type = this.typeService.getType();
		return type;
	}
}
