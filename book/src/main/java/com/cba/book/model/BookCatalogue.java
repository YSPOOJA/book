package com.cba.book.model;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="book")
public class BookCatalogue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ISBN;

    @Column(name="title")
    private String title;

    @Column(name="author")
    private String author;


    @Column(name="pdate")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date pdate;


    public BookCatalogue(Long ISBN, String title, String author, Date pdate) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.pdate = pdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public Long getISBM() {
        return ISBN;
    }

    public void setISBN(Long ISBM) {
        this.ISBN = ISBN;
    }
}
