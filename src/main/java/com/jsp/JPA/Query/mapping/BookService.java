package com.jsp.JPA.Query.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooksByAuthor(Long authorId) {
        return bookRepository.findBooksByAuthorId(authorId);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long bookId, Book bookDetails) {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(bookDetails.getTitle());
            existingBook.setAuthor(bookDetails.getAuthor());
            return bookRepository.save(existingBook);
        } else {
            throw new ResourceNotFoundException("Book not found with id " + bookId);
        }
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}

