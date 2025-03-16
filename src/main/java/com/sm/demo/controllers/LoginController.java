package com.sm.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sm.demo.payload.request.BookRequest;
import com.sm.demo.payload.request.LoginRequest;
import com.sm.demo.service.BooksService;
import com.sm.demo.service.LoginService;
import com.sm.demo.service.impl.LoginServiceImpl;

import jakarta.validation.Valid;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	LoginService loginService;

	@GetMapping("/loginInfoByUserPwd")
	public String getBookInfoById( LoginRequest login) {
		return loginService.getLoginByUserPwd(login);
	}
}
