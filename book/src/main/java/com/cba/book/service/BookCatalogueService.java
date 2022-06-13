package com.cba.book.service;
import java.util.List;
import com.cba.book.model.BookCatalogue;
public interface BookCatalogueService {

    public List<BookCatalogue> getAllBooks();
    public BookCatalogue addBook(BookCatalogue bookDetails);
    public BookCatalogue updateBook(BookCatalogue bookDetails);
    public void deleteBookByIsbn(Long ISBN);

    public List<BookCatalogue> getBooksByTitleAndAuthor(String title, String author);
}
