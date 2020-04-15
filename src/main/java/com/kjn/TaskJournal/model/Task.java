package com.kjn.TaskJournal.model;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

/**
 * Created by Koujianing
 * Date: 2020/4/14
 * Time: 22:45
 */
public class Task {
	private long id;
	private String name;
	private String description;
	private long type_id;
	private String link;
	private String label;
	private long status;
	private String is_delete;
	private String deadline;
	private String created_at;

	public Task (long id, String name, String description, long type_id, String link, String label, long status, String is_delete, String deadline, String created_at) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.type_id = type_id;
		this.link = link;
		this.label = label;
		this.status = status;
		this.is_delete = is_delete;
		this.deadline = deadline;
		this.created_at = created_at;
	}

	public Task(){
		super();
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

	public String getDescription () {
		return description;
	}

	public void setDescription (String description) {
		this.description = description;
	}

	public long getType_id () {
		return type_id;
	}

	public void setType_id (long type_id) {
		this.type_id = type_id;
	}

	public String getLink () {
		return link;
	}

	public void setLink (String link) {
		this.link = link;
	}

	public String getLabel () {
		return label;
	}

	public void setLabel (String label) {
		this.label = label;
	}

	public long getStatus () {
		return status;
	}

	public void setStatus (long status) {
		this.status = status;
	}

	public String getIs_delete () {
		return is_delete;
	}

	public void setIs_delete (String is_delete) {
		this.is_delete = is_delete;
	}

	public String getDeadline () {
		return deadline;
	}

	public void setDeadline (String deadline) {
		this.deadline = deadline;
	}

	public String getCreated_at () {
		return created_at;
	}

	public void setCreated_at (String created_at) {
		this.created_at = created_at;
	}
}
