package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
public class BookRepositoryJdbc implements BookRepository{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	@Override
	public List<Book> findAllBooks() {
		String sql = "select id, name, price, amount, pub from book";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
	}

	@Override
	public Optional<Book> getBookById(Integer id) {
		String sql = "select id, name, price, amount, pub from book where id=?";
		
		try {
			Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
			return Optional.of(book);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return Optional.empty();
		}
		
	}

	@Override
	public Boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateBook(Integer id, Book book) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteBookById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
