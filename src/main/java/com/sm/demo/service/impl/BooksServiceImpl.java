package com.sm.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.sm.demo.dao.BooksResourceMapper;
import com.sm.demo.dao.TutorialsResourceMapper;
import com.sm.demo.dao.UsersResourceMapper;
import com.sm.demo.domain.BooksResource;
import com.sm.demo.domain.TutorialsResource;
import com.sm.demo.domain.UsersResource;
import com.sm.demo.models.Books;
import com.sm.demo.payload.request.LoginRequest;
import com.sm.demo.repository.BooksRepository;
import com.sm.demo.service.BooksService;

@Service// 
public class BooksServiceImpl extends BaseService<Books> implements BooksService {

	@Autowired
	BooksRepository booksRepository;
	@Autowired
	TutorialsResourceMapper tutorialsResourceMapper;
	@Autowired
	BooksResourceMapper booksResourceMapper;
	@Autowired
	UsersResourceMapper usersResourceMapper;
    @Override
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
    
    @Override
    public String getBookById(String id) {
    	Gson gson = new Gson();
    	List<BooksResource> bookObj = booksResourceMapper.selectBookById(id);
		System.out.println(bookObj);
		String book = gson.toJson(bookObj).toString();
        return book;
    }
    @Override
    public String getBookByName(String name) {
    	Gson gson = new Gson();
    	List<BooksResource> bookObj = booksResourceMapper.selectBookByName(name);
		System.out.println(bookObj);
		String book = gson.toJson(bookObj).toString();
        return book;
    }
    
}
