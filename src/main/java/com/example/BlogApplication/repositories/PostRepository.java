package com.example.BlogApplication.repositories;

import com.example.BlogApplication.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;


// Create JPA Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
