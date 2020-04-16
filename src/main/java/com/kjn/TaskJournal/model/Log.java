package com.kjn.TaskJournal.model;

/**
 * Created by Koujianing
 * Date: 2020/4/16
 * Time: 21:45
 */
public class Log {
	private long id;
	private long task_id;
	private String time;
	private long status;
	private long old_status;
//	private String user;

	public Log (long id, long task_id, String time, long status, long old_status) {
		this.id = id;
		this.task_id = task_id;
		this.time = time;
		this.status = status;
		this.old_status = old_status;
	}
	public Log(){
		super();
	}

	public long getId () {
		return id;
	}

	public void setId (long id) {
		this.id = id;
	}

	public long getTask_id () {
		return task_id;
	}

	public void setTask_id (long task_id) {
		this.task_id = task_id;
	}

	public String getTime () {
		return time;
	}

	public void setTime (String time) {
		this.time = time;
	}

	public long getStatus () {
		return status;
	}

	public void setStatus (long status) {
		this.status = status;
	}

	public long getOld_status () {
		return old_status;
	}

	public void setOld_status (long old_status) {
		this.old_status = old_status;
	}

	@Override
	public String toString () {
		return "Log{" +
				"id=" + id +
				", task_id=" + task_id +
				", time='" + time + '\'' +
				", status=" + status +
				", old_status=" + old_status +
				'}';
	}
}
