package com.sm.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.google.gson.Gson;
import com.sm.demo.dao.BooksResourceMapper;
import com.sm.demo.dao.TutorialsResourceMapper;
import com.sm.demo.dao.UsersResourceMapper;
import com.sm.demo.domain.BooksResource;
import com.sm.demo.domain.TutorialsResource;
import com.sm.demo.domain.UsersResource;
import com.sm.demo.dto.ext.UserExt;
import com.sm.demo.models.Books;
import com.sm.demo.models.User;
import com.sm.demo.payload.request.LoginRequest;
import com.sm.demo.repository.BooksRepository;
import com.sm.demo.repository.RoleRepository;
import com.sm.demo.repository.UserRepository;
import com.sm.demo.security.jwt.JwtUtils;
import com.sm.demo.service.BooksService;
import com.sm.demo.service.LoginService;

@Service// 
public class LoginServiceImpl extends BaseService<Books> implements LoginService {

	@Autowired
	BooksRepository booksRepository;
	@Autowired
	TutorialsResourceMapper tutorialsResourceMapper;
	@Autowired
	BooksResourceMapper booksResourceMapper;
	@Autowired
	UsersResourceMapper usersResourceMapper;
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtUtils jwtUtils;

    @Override
    public String loginUser(LoginRequest loginRequest) {

    	
      Gson gson = new Gson();
  	  Optional<User> t = userRepository.findByUsername(loginRequest.getUsername());
  	  String user = "";
  	  UserExt token = new  UserExt();
  	  if(!ObjectUtils.isEmpty(t)) {
  		  token.setUserName(t.get().getUsername());
  		  token.setToken(jwtUtils.generateTokenFromUsername(loginRequest.getUsername()));
  		  user = gson.toJson(token).toString();
  	  } else {
  		  user = gson.toJson("").toString();
  	  }
  	  return user;
    }
    
    
    
    public String getBooksList() {
		Gson gson = new Gson();
		System.out.println(gson.toJson(booksRepository.findAll()));
		String books = gson.toJson(booksRepository.findAll()).toString();
		TutorialsResource tutorialsResource = tutorialsResourceMapper.selectTutorialsById(202);
		System.out.println(tutorialsResource);
		
		List<BooksResource> list = booksResourceMapper.selectBooksLimit(100);
		System.out.println(list);
		books = gson.toJson(list).toString();
        return books;
    }
    
    public String getBookById(String id) {
    	Gson gson = new Gson();
    	List<BooksResource> bookObj = booksResourceMapper.selectBookById(id);
    	if(bookObj.size() > 0) {
    		System.out.println(bookObj.get(0));
    		return gson.toJson(bookObj.get(0)).toString();
    	}
		
		String book = gson.toJson(bookObj).toString();
        return book;
    }
    public String getLoginByUserPwd(String id) {
    	Gson gson = new Gson();
    	List<BooksResource> bookObj = booksResourceMapper.selectBookById(id);
    	if(bookObj.size() > 0) {
    		System.out.println(bookObj.get(0));
    		return gson.toJson(bookObj.get(0)).toString();
    	}
		
		String book = gson.toJson(bookObj).toString();
        return book;
    }
    public String getLoginByUserPwd(LoginRequest loginRequest) {
    	Gson gson = new Gson();
    	List<UsersResource> userObj = usersResourceMapper.selectUserByUserPwd(loginRequest.getUsername(), loginRequest.getPassword());
    	if(userObj.size() > 0) {
    		System.out.println(userObj.get(0));
    		return gson.toJson(userObj.get(0)).toString();
    	}
		
		String user = gson.toJson(userObj).toString();
        return user;
    }
    
}
