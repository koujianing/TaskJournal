package com.kjn.TaskJournal.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Koujianing
 * Date: 2020/4/13
 * Time: 19:42
 */
public class User {
	private long id;
	private String nickname;
	private String mobile;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String role;

	public User (long id, String nickname, String mobile, String password, String role) {
		this.id = id;
		this.nickname = nickname;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
	}

	public long getId () {
		return id;
	}

	public void setId (long id) {
		this.id = id;
	}

	public String getNickname () {
		return nickname;
	}

	public void setNickname (String nickname) {
		this.nickname = nickname;
	}

	public String getMobile () {
		return mobile;
	}

	public void setMobile (String mobile) {
		this.mobile = mobile;
	}

	public String getPassword () {
		return password;
	}

	public void setPassword (String password) {
		this.password = password;
	}

	public String getRole () {
		return role;
	}

	public void setRole (String role) {
		this.role = role;
	}
}
