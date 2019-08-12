package com.example.BlogApplication.services;

import com.example.BlogApplication.model.Post;
import com.example.BlogApplication.repositories.PostRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

// Write Post model Methods

@Service
public class PostServicesImpl implements PostServices {
    private final PostRepository postRepository;

    public PostServicesImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    // Get All Posts
    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
    // Get Single Post
    @Override
    public Post findPostById(Long id) {
        return postRepository.findById(id).get();
    }
    // Create Post with Forms input values
    @Override
    public Post createPost(String title, String content) {
        Post p1 = new Post();
        p1.setTitle(title);
        p1.setContent(content);
        return postRepository.save(p1);
    }
    // Update Posts
    @Override
    public Post updatePost(String title, String content, Long id) {
        Post p = findPostById(id);
        p.setTitle(title);
        p.setContent(content);
        return postRepository.save(p);
    }
    // Delete Posts
    @Override
    public List<Post> deletePost(Long id) {
        postRepository.deleteById(id);
        return postRepository.findAll();
    }

}
