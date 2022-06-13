package com.cba.book.repository;

import com.cba.book.model.BookCatalogue;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookCatalogueRepositoryImpl implements BookCatalogueRepositoryCustom{

   @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BookCatalogue> findBooksByTitleAndAuthor(String title, String author) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();

        Root<BookCatalogue> book = cq.from(BookCatalogue.class);

        Predicate titlePredicate=cb.equal(book.get("title"),title);
        Predicate authorPredicate=cb.equal(book.get("author"),author);

        cq.where(titlePredicate,authorPredicate);

        TypedQuery<BookCatalogue> query=entityManager.createQuery(cq);
        return query.getResultList();
    }
}
