package com.example.web.services;

import com.example.web.entities.Post;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;


@Service
public class PostService {

    public Iterable<Post> getAllPosts() {
        return Arrays.asList(new Post(), new Post());
    }

    public void insert(Post post) {
        // postRepository.save(post);
        System.out.println("post jest");
    }
}