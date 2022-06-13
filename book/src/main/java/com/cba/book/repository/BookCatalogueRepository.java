package com.cba.book.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cba.book.model.BookCatalogue;
public interface BookCatalogueRepository extends JpaRepository<BookCatalogue, Long>, BookCatalogueRepositoryCustom {
}
