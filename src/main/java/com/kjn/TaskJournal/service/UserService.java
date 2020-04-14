package com.kjn.TaskJournal.service;

import com.kjn.TaskJournal.model.User;

import java.util.List;

/**
 * Created by Koujianing
 * Date: 2020/4/13
 * Time: 19:43
 */
public interface UserService {
	public User getUserById (long userId);

	List<User> listUser (int page, int pageSize);
}
