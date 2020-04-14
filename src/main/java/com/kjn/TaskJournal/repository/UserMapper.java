package com.kjn.TaskJournal.repository;

import com.kjn.TaskJournal.model.User;

import java.util.List;

/**
 * Created by Koujianing
 * Date: 2020/4/13
 * Time: 20:03
 */
public interface UserMapper {
	//对应xml映射文件元素的id
	User selectByPrimaryKey (long id);
	List<User> selectUser();
}
