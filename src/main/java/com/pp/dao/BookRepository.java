package com.pp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pp.pojo.Books;
@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {
public List<Books> findByGenre(String genre);
}
