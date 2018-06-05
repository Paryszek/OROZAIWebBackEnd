package com.example.web.controllers;

import com.example.web.entities.MemberLogin;
import com.example.web.entities.Post;
import com.example.web.entities.Member;
import com.example.web.services.PostService;
import com.example.web.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AppController {

    @Autowired
    private PostService postService;
    @Autowired
    private MemberService memberService;

    @GetMapping(value="/posts")
    public List<Post> posts(){
        return postService.getAllPosts();
    }

    @PostMapping(value="/post")
    public String publishPost(@RequestBody Post post){
        System.out.println(post);
        if(post.getDateCreated() == null)
            post.setDateCreated(new Date());
        postService.insert(post);
        return "Post published";
    }

    @PostMapping(value="/login")
    public String loginMember(@RequestBody MemberLogin member) {
        if (member != null && !member.getLogin().equals("") && !member.getPassword().equals("")) {
            Member _member = memberService.getUser(member);
            if (_member != null) {
                return "Login succeeded";
            } else {
                return "Login failed no such member";
            }
        }
        return "Login failed";
    }
}
