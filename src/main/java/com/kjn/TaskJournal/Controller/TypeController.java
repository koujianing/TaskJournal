package com.kjn.TaskJournal.Controller;

import com.github.pagehelper.PageInfo;
import com.kjn.TaskJournal.model.Task;
import com.kjn.TaskJournal.model.Type;
import com.kjn.TaskJournal.service.TypeService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.security.auth.message.callback.PrivateKeyCallback;
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

	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	public Type getType (@PathVariable long id) throws Exception {
		Type type = this.typeService.getTypeById(id);
		return type;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<Type> getAllType () throws Exception {
		List<Type> type = this.typeService.getType();
		return type;
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public PageInfo<Type> listType (
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "count", required = false, defaultValue = "5") int pageSize
	) {
		List<Type> result = typeService.listType(page, pageSize);
		PageInfo<Type> pi = new PageInfo<Type>(result);
		return pi;
	}

	@RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json")
	public void postType (Type type) throws Exception {
		this.typeService.postType(type);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
	public void putType (@PathVariable long id, Type type) {
//		Task oldTask = this.taskService.getTaskById(id);
//		task.setId(id);
//		Task newTask = oldTask.mixinData(task);
//		this.taskService.putTask(newTask);
		Type oldType = this.typeService.getTypeById(id);
		type.setId(id);
		Type newType = oldType.mixinData(type);
		this.typeService.putType(newType);

	}
}
