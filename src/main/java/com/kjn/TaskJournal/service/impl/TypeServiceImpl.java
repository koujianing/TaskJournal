package com.kjn.TaskJournal.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kjn.TaskJournal.model.Type;
import com.kjn.TaskJournal.repository.TypeMapper;
import com.kjn.TaskJournal.service.TypeService;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import com.kjn.TaskJournal.Controller.TypeController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Koujianing
 * Date: 2020/4/15
 * Time: 22:18
 */
@Service("typeService")
public class TypeServiceImpl implements TypeService {
	@Resource
	private TypeMapper typeMapper;
	@Override
	public Type getTypeById(long typeId){
		return typeMapper.selectByPrimaryById(typeId);
	}
	public List<Type> getType() {
		return typeMapper.selectType();
	}
	@Override
	public List<Type> listType(int page,int pageSize) {
		List<Type> result = null;
		try{
			PageHelper.startPage(page,pageSize);
			PageHelper.orderBy("id ASC");
			result = this.typeMapper.selectType();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public void postType(Type type){
		typeMapper.insertType(type);
	}
	@Override
	public void putType(Type type){
		typeMapper.updateType(type);
	}
}
