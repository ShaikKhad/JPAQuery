package com.jsp.JPA.Query.mapping;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long> {
	 @Query("SELECT b FROM Book b JOIN FETCH b.author WHERE b.author.id = :authorId")
	    List<Book> findBooksByAuthorId(@Param("authorId") Long authorId);
	}

