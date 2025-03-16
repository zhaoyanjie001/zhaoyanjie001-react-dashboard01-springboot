package com.sm.demo.dto.ext;


public class UserExt {

  private String token;
  private String userName;
  
  public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public UserExt() {
	  super();
  }

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}

}
