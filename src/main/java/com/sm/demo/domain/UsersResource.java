package com.sm.demo.domain;

public class UsersResource {
	private Integer id;
	private String email;
	private String password;
	private String username;
	private Long role;
	private Long name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getRole() {
		return role;
	}
	public void setRole(Long role) {
		this.role = role;
	}
	public Long getName() {
		return name;
	}
	public void setName(Long name) {
		this.name = name;
	}

}