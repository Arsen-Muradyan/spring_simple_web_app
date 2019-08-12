package com.example.BlogApplication.BootStrap;

import com.example.BlogApplication.model.Post;
import com.example.BlogApplication.repositories.PostRepository;
import com.example.BlogApplication.services.PostServices;
import com.example.BlogApplication.services.PostServicesImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Creating Fake Data
//@Component
public class BootStrapData implements CommandLineRunner {
    private final PostRepository postRepository;

    public BootStrapData(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Posts Load Data");
        Post p1 = new Post();
        p1.setTitle("Post one");
        p1.setContent("This is Post body");
        postRepository.save(p1);
        System.out.println("Saved Posts: " + postRepository.count());

    }
}
