package com.kjn.TaskJournal.model;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import com.kjn.TaskJournal.model.Type;

/**
 * Created by Koujianing
 * Date: 2020/4/14
 * Time: 22:45
 */
public class Task {
	private long id = -1;
	private String name = null;
	private String description = null;
	private long type_id = -1;
	private Type type;
	private String link = null;
	private String label = null;
	private long status = -1;
	private String is_deleted = null;
	private String deadline = null;
	private String created_at = null;

	public Task (long id, String name, String description, long type_id, String link, String label, long status, String is_deleted, String deadline, String created_at) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.type_id = type_id;
		this.link = link;
		this.label = label;
		this.status = status;
		this.is_deleted = is_deleted;
		this.deadline = deadline;
		this.created_at = created_at;
	}

	public Task () {
		super();
	}

	public Type getType () {
		return type;
	}

	public void setType (Type type) {
		this.type = type;
	}

	public Task mixinData (Task task) {
		/*Task{id=8, name='null', description='null',
			type_id=0, link='null', label='null',
			status=0, is_deleted='null',
			deadline='null', created_at='null'}*/

		if (task.name != null) {
			this.name = task.name;
		}
		if (task.description != null) {
			this.description = task.description;
		}
		if (task.type_id != -1) {
			this.type_id = task.type_id;
		}
		if (task.link != null) {
			this.link = task.link;
		}
		if (task.label != null) {
			this.label = task.label;
		}
		if (task.status != -1) {
			this.status = task.status;
		}
		if (task.is_deleted != null) {
			this.is_deleted = task.is_deleted;
		}
		if (task.deadline != null) {
			this.deadline = task.deadline;
		}
		if (task.created_at != null) {
			this.created_at = task.created_at;
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
		return is_deleted;
	}

	public void setIs_delete (String is_deleted) {
		this.is_deleted = is_deleted;
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

	@Override
	public String toString () {
		return "Task{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", type_id=" + type_id +
				", type=" + type +
				", link='" + link + '\'' +
				", label='" + label + '\'' +
				", status=" + status +
				", is_deleted='" + is_deleted + '\'' +
				", deadline='" + deadline + '\'' +
				", created_at='" + created_at + '\'' +
				'}';
	}
}
