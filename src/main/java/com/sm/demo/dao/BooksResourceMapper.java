package com.sm.demo.dao;

import com.sm.demo.domain.BooksResource;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BooksResourceMapper {
    public List<BooksResource> selectBooks(@Param("id") String id, @Param("title") String title);
    
    public List<BooksResource> selectBooksLimit(@Param("limit") int limit);
    public List<BooksResource> selectBookById(@Param("id") String id);
    public List<BooksResource> selectBookByName(@Param("name") String name);
    
}