package com.seven.academy.mvc.models;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // BigInt, PK, AI, No Null

    @NotNull
    @Size(min = 5, max = 200)
    private String title; // VARCHAR(255)

    @NotNull
    @Size(min = 5)
    @Column(columnDefinition="TEXT")
    private String description;

    @NotNull
    @Size(min = 3, max = 40)
    private String language; // VARCHAR(255)

    @NotNull
    @Min(100)
    private Integer numberOfPages; // int

    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt; // DateTime

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt; // DateTime

    public Book() {}

    public Book(String title, String desc, String lang, Integer numOfPages) {
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = numOfPages;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}

