package com.sm.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sm.demo.models.User;
import com.sm.demo.repository.UserRepository;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
   @Autowired
   UserRepository userRepository;

	  
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/userInfo")
  public String userInfoAccess() {
	  Gson gson = new Gson();
	  User userDto = new User();
      System.out.println(gson.toJson(userRepository.findByUsername("root").get()));
//      System.out.println(gson.toJson(userRepository.findByUsername(userDto).get()));
      String user = gson.toJson(userRepository.findAll()).toString();
      return user;
  }
  @GetMapping("/user")
  public String userAccess() {
    return "000<br/><a href='#'>kkk</a>";
  }
  @GetMapping("/mod")
  @PreAuthorize("hasRole('MODERATOR')")
  public String moderatorAccess() {
    return "Moderator Board.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
}
