package com.kjn.TaskJournal.service.impl;

import com.github.pagehelper.PageHelper;
import com.kjn.TaskJournal.model.User;
import com.kjn.TaskJournal.repository.UserMapper;
import com.kjn.TaskJournal.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Koujianing
 * Date: 2020/4/13
 * Time: 19:43
 */
@Service("userService")
public class UserServiceImpl implements UserService {
	//注入mapper类
	@Resource
	private UserMapper userMapper;
	@Override
	public User getUserById(long userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
	@Override
	public List<User> listUser(int page,int pageSize) {
		List<User> result = null;
		try {
			PageHelper.startPage(page,pageSize);
			PageHelper.orderBy("id ASC ");
			result = userMapper.selectUser();
		}catch (Exception e){
			e.printStackTrace();
		}
		return result;
	}
}
