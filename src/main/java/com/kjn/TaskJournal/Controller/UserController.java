package com.kjn.TaskJournal.Controller;

import com.github.pagehelper.PageInfo;
import com.kjn.TaskJournal.model.User;
import com.kjn.TaskJournal.service.UserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Koujianing
 * Date: 2020/4/13
 * Time: 19:41
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;

	@RequestMapping(value="{id}",method = RequestMethod.GET,produces ="application/json")
	public User getUser(@PathVariable long id) throws Exception {
		User user = this.userService.getUserById(id);
		return user;
	}
	@RequestMapping(value="",method = RequestMethod.GET,produces ="application/json")
	public PageInfo<User> listUser (
			@RequestParam(value="page", required=false, defaultValue="1") int page,
			@RequestParam(value="page-size", required=false, defaultValue="5") int pageSize){
		List<User> result = userService.listUser(page,pageSize);
		//PageInfo包装结果，返回更多的分页相关信息
		PageInfo<User> pi = new PageInfo<User>(result);
		return pi;
	}

}
