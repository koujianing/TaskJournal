package com.kjn.TaskJournal.model;

/**
 * Created by Koujianing
 * Date: 2020/4/15
 * Time: 22:13
 */
public class Type {
	private long id;
	private String name;
	private String color;
	private String is_deleted =null;

	public Type (long id, String name, String color,String is_deleted) {
		this.id = id;
		this.name = name;
		this.color = color;
		this.is_deleted = is_deleted;
	}
	public Type(){
		super();
	}

	public Type mixinData(Type type){
		if(type.name != null){
		this.name = type.name;
		}
		if(type.color != null){
			this.color = type.color;
		}
		if(type.is_deleted != null){
			this.is_deleted = type.is_deleted;
		}
		return this;
	}

	public long getId () {
		return id;
	}

	public void setId (long id) {
		this.id = id;
	}

	public String getName () {
		return name;
	}

	public void setName (String name) {
		this.name = name;
	}

	public String getColor () {
		return color;
	}

	public void setColor (String color) {
		this.color = color;
	}

	public String getIs_deleted () {
		return is_deleted;
	}

	public void setIs_deleted (String is_deleted) {
		this.is_deleted = is_deleted;
	}
}
