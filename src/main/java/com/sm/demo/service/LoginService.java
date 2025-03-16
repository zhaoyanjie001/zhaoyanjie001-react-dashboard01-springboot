package com.sm.demo.service;

import com.sm.demo.payload.request.LoginRequest;

public interface LoginService {
    public String loginUser(LoginRequest loginRequest);
    public String getLoginByUserPwd(LoginRequest loginRequest);
}
