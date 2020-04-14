package com.kjn.TaskJournal.common.util;

import org.omg.PortableInterceptor.ServerRequestInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Koujianing
 * Date: 2020/4/14
 * Time: 17:23
 */
public class Result implements Serializable {
	@SuppressWarnings("unused")
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(Result.class);
	private static final long serialVersionUID = -1802122468331526708L;
	//状态值，应该对应http的状态值
	private int status = -1;
	//message状态消息
	private String message = "待处理";
	//data可放入键值对
	private Map<String,Object> data = new HashMap<String,Object>();
	public Result(){}
	public Result(int status,String message){
		this.status = status;
		this.message = message;
	}

	public int getStatus () {
		return status;
	}

	public void setStatus (int status) {
		this.status = status;
	}

	public String getMessage () {
		return message;
	}

	public void setMessage (String message) {
		this.message = message;
	}

	public Map<String, Object> getData () {
		return data;
	}

	public void setData (Map<String, Object> data) {
		this.data = data;
	}
	public void removeData(String key){
		data.remove(key);
	}
	public void putData(String key, Object value) {
		data.put(key, value);
	}
	@Override
	public String toString () {
		return "Result{" +
				"status=" + status +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}
}
