package com.example.BlogApplication.model;


import lombok.Data;

import javax.persistence.*;

// Create Model
@Data
@Entity
// Table Name
@Table(name="posts")
public class Post {
    // Table Columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="title")
    private String title;
    @Column(name="content", columnDefinition = "text")
    private String content;
}
