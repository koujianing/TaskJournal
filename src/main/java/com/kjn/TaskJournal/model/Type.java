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

	public Type (long id, String name, String color) {
		this.id = id;
		this.name = name;
		this.color = color;
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
}
