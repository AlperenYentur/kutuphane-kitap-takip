package com.user.kitaptakip.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    private String title;
    private String author;
    private int year;
    private String isbn;
    private String category;
    private boolean isAvailable = true;
}