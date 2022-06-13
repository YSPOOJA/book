package com.cba.book.controller;

import com.cba.book.exception.CustomBookCatalogueException;
import com.cba.book.model.BookCatalogue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cba.book.repository.BookCatalogueRepository;
import com.cba.book.service.BookCatalogueService;
import com.cba.book.exception.NoSuchBookExistsException;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api")
public class BookCatalogueController {

    @Autowired
    private BookCatalogueService bookCatalogueService;
    @Autowired
    private BookCatalogueRepository bookCatalogueRepository;

    @GetMapping("/books")
    public ResponseEntity<List<BookCatalogue>> getAllBooks(){
        return new ResponseEntity<>(bookCatalogueService.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<BookCatalogue> addBook(@RequestBody BookCatalogue bookDetails){

        if (bookDetails != null && bookDetails.getTitle() != null) {
            return new ResponseEntity<>(bookCatalogueService.addBook(bookDetails), HttpStatus.CREATED);
        } else {
            throw new CustomBookCatalogueException("title cannot be null");
        }
    }

    @PutMapping("/book/{ISBN}")
    public ResponseEntity<BookCatalogue> updateBook(@PathVariable("ISBN")final Long ISBN, @RequestBody final BookCatalogue bookDetails){
        BookCatalogue bookCatalogue = getBookDet(ISBN);
        if (bookCatalogue != null) {
            bookDetails.setISBN(ISBN);
            return new ResponseEntity<>(bookCatalogueService.updateBook(bookDetails), HttpStatus.OK);
        } else {
            throw new NoSuchBookExistsException("No Such book exists!!");
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployeeById(@PathVariable("ISBN") long ISBN) {
        //check if employee exist in database
        BookCatalogue bc = getBookDet(ISBN);

        if (bc != null) {
           bookCatalogueService.deleteBookByIsbn(ISBN);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new NoSuchBookExistsException("No Such Employee exists!!");
        }
    }
    @GetMapping("/book")
    public ResponseEntity<List<BookCatalogue>> getBooksByTitleAndAuthor(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author){
        return new ResponseEntity<>(bookCatalogueService.getBooksByTitleAndAuthor(title, author), HttpStatus.OK);
    }


    private BookCatalogue getBookDet(long ISBN) {
        Optional<BookCatalogue> bookObj = bookCatalogueRepository.findById(ISBN);
        if (bookObj.isPresent()) {
            return bookObj.get();
        }
        return null;
    }
}
