package com.example.BlogApplication.services;

import com.example.BlogApplication.model.Post;
import com.example.BlogApplication.repositories.PostRepository;
import java.util.List;

// Create Post service interface
public interface PostServices  {
    List<Post> findAllPosts();
    Post findPostById(Long id);
    Post createPost(String title, String content);
    Post updatePost(String title, String content, Long id);
    List<Post> deletePost(Long id);
}
