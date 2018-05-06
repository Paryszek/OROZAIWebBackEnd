package com.example.web.controllers;

import com.example.web.entities.Post;
import com.example.web.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class AppController {

    @Autowired
    private PostService postService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/posts")
    public Iterable<Post> posts(){
        return postService.getAllPosts();
    }

    @PostMapping(value="/post")
    public void publishPost(@RequestBody Post post){
        if(post.getDateCreated() == null)
            post.setDateCreated(new Date());
        postService.insert(post);
    }
}
