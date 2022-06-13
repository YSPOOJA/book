package com.cba.book.repository;
import com.cba.book.model.BookCatalogue;
import java.util.List;

public interface BookCatalogueRepositoryCustom {
 List<BookCatalogue> findBooksByTitleAndAuthor(String title,String author);
}
