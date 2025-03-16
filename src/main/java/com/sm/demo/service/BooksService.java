package com.sm.demo.service;

import com.sm.demo.payload.request.LoginRequest;

public interface BooksService {
    public String getBooksList();
    public String getBookById(String id);
    public String getBookByName(String name);
}
