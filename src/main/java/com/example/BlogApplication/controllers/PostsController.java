package com.example.BlogApplication.controllers;

import com.example.BlogApplication.services.PostServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

//Posts Controller

@Controller
@RequestMapping(PostsController.BASE_URL)
public class PostsController {
    // Get Post Services
    private final PostServices postServices;
    public static final String BASE_URL = "posts";
    public PostsController(PostServices postServices) {
        this.postServices = postServices;
    }
    // Get All Posts
    @GetMapping
    public String getAllPosts(Model model) {
        model.addAttribute("posts", postServices.findAllPosts());
        return "index";
    }
    // New Post Page
    @GetMapping("/new")
    public String newPost() {
        return "new";
    }
    // Get Single Post with id
    @GetMapping("{id}")
    public String getPost(@PathVariable Long id, Model model) {
        model.addAttribute("post", postServices.findPostById(id));
        return "show";
    }
    // Create Post action
    @PostMapping
    public String createPost(@RequestBody MultiValueMap<String, String> post) {
        postServices.createPost(post.getFirst("title"), post.getFirst("content"));
        return "redirect:/posts";
    }
    // Edit Post page
    @GetMapping("{id}/edit")
    public String editPage(@PathVariable Long id, Model model) {
        model.addAttribute("post", postServices.findPostById(id));
        return "edit";
    }
    // Edit Post Action
    @PostMapping("{id}/update")
    public String updatePost(@RequestBody MultiValueMap<String, String> post, @PathVariable Long id) {
        postServices.updatePost(post.getFirst("title"), post.getFirst("content"), id);
        return "redirect:/posts/"+id;
    }
    // Delete Post action
    @PostMapping("{id}")
    public String deletePost(@PathVariable Long id) {
        postServices.deletePost(id);
        return "redirect:/posts";
    }
}

