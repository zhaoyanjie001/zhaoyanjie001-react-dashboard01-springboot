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

import jakarta.validation.Valid;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/books")
public class BooksController {

	@Autowired
	BooksService booksService;

	@GetMapping("/booksInfo")
	public String getBooksInfo() {
		return booksService.getBooksList();
	}
	@PostMapping("/booksInfoById")
	public String getBookInfoById( @RequestBody BookRequest book) {
		return booksService.getBookById(book.getId());
	}
	@PostMapping("/booksInfoByName")
	public String getBookInfoByName( @RequestBody BookRequest book) {
		return booksService.getBookByName(book.getName());
	}
//	@PostMapping("/booksInfoById")
//	public String getBookInfoById(@Valid @RequestBody BookRequest book) {
//		return booksService.getBookById(book.getId());
//	}
//	@GetMapping("/booksInfoById")
//	public String getBookInfoById(String booksId) {
//		return booksService.getBookById(booksId);
//	}
//	@GetMapping("/booksInfoById")
//	public String getBookInfoById( LoginRequest login) {
//		return booksService.getBookById(login);
//	}
}
