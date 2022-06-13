package com.cba.book.service;

import com.cba.book.model.BookCatalogue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cba.book.repository.BookCatalogueRepository;
import java.util.ArrayList;
import java.util.List;
import com.cba.book.exception.CustomBookCatalogueException;

@Service
public class BookCatalogueServiceImpl implements BookCatalogueService {

    @Autowired
    private BookCatalogueRepository bookcatalogueRepository;

    @Override
    public List<BookCatalogue> getAllBooks() {
        List<BookCatalogue> bookList = new ArrayList<>();
        bookcatalogueRepository.findAll().forEach(bookList::add);
        return bookList;
    }

    @Override
    public BookCatalogue addBook(BookCatalogue bookDetails) {
        if (bookDetails != null && bookDetails.getTitle() != null) {
            return bookcatalogueRepository.save(bookDetails);
        } else {
            throw new CustomBookCatalogueException("title cannot be null");
        }
    }

    @Override
    public BookCatalogue updateBook(BookCatalogue bookDetails) {
        return bookcatalogueRepository.save(bookDetails);
    }

    @Override
    public void deleteBookByIsbn(Long ISBN) {
        bookcatalogueRepository.deleteById(ISBN);
    }

    @Override
    public List<BookCatalogue> getBooksByTitleAndAuthor(String title, String author) {
        return bookcatalogueRepository.findBooksByTitleAndAuthor(title, author);
    }
}
