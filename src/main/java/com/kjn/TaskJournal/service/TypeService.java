package com.kjn.TaskJournal.service;

import com.kjn.TaskJournal.model.Type;

import java.util.List;

/**
 * Created by Koujianing
 * Date: 2020/4/15
 * Time: 22:18
 */
public interface TypeService {
	public Type getTypeById(long id);
	public List<Type> getType();
	public List<Type> listType(int page,int pageSize);
	public void postType(Type type);
	public void putType(Type type);
}
