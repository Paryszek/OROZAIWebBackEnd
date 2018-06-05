package com.example.web.controllers;

import com.example.web.entities.Post;
import com.example.web.entities.User;
import com.example.web.services.PostService;
import com.example.web.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class AppController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/posts")
    public List<Post> posts(){
        return postService.getAllPosts();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/post")
    public String publishPost(@RequestBody Post post){
        System.out.println(post);
        if(post.getDateCreated() == null)
            post.setDateCreated(new Date());
        postService.insert(post);
        return "Post was published";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/login")
    public String loginUser(@RequestBody User user) {
        if (user != null && !user.getLogin().equals("") && !user.getPassword().equals(""))
            userService.insertUser(user);
        {}
        return "Login succeded";
    }
}
