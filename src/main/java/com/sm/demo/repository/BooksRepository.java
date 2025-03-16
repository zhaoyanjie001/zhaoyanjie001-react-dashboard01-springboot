package com.sm.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm.demo.models.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
  List<Books> findAll();
}
