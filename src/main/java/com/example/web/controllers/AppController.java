package com.example.web.controllers;

import com.example.web.entities.MemberLogin;
import com.example.web.entities.Post;
import com.example.web.entities.Member;
import com.example.web.entities.Role;
import com.example.web.services.PostService;
import com.example.web.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AppController {

    @Autowired
    private PostService postService;
    @Autowired
    private MemberService memberService;

    @GetMapping(value="/posts")
    public List<Post> posts(int count){
        List<Post> posts = new ArrayList<>();
        if (this.postService.getAllPosts().isEmpty()) {
            Post post = new Post();
            post.setTitle("Lorem ipsum dolor sit amet");
            post.setBody("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam tincidunt luctus augue ac consectetur. ");
            post.setOwner("test");
            post.setDateCreated(new Date().toString());
            postService.insert(post);
        }
        if(count == 0) {
            posts = postService.getAllPosts();
        } else {
            posts = postService.getNumberOfPosts(count);
        }

        return posts;
    }

    @GetMapping(value="/role")
    public Member role(String login){
        if (login != null && !login.equals("")) return memberService.getUserByName(login);
        return null;
    }

    @PostMapping(value="/post")
    public Boolean publishPost(@RequestBody Post post){
        System.out.println(post);
        if(post.getDateCreated().equals(""))
            post.setDateCreated(new Date().toString());
        postService.insert(post);
        return true;
    }

    @PostMapping(value="/removepost")
    public Boolean removePost(@RequestBody int id){
        return postService.removePost(id);
    }

    @PostMapping(value="/register")
    public Boolean registerMember(@RequestBody Member member) {
        if (member != null &&
                member.getLogin().length() != 0 &&
                member.getPassword().length() != 0 &&
                member.getFirstName().length() != 0 &&
                member.getLastName().length() != 0) {
            Member m = memberService.getUserByName(member.getLogin());
            if (m.getLogin() != null) {
                return false;
            }
            member.setRoles(Arrays.asList(new Role("USER")));

            memberService.insertUser(member);
        } else {
            return false;
        }
        return true;
    }

    @PostMapping(value="/login")
    public Boolean loginMember(@RequestBody MemberLogin member) {
        if (memberService.getUsers().isEmpty())
        {
            Member admin = new Member();
            admin.setLogin("admin");
            admin.setPassword("admin");
            admin.setRoles(Arrays.asList(new Role("USER"), new Role("ADMIN")));
            memberService.insertUser(admin);

            Member user = new Member();
            user.setLogin("user");
            user.setPassword("user");
            user.setRoles(Arrays.asList(new Role("USER")));
            memberService.insertUser(user);
        }
        if (member != null && !member.getLogin().equals("") && !member.getPassword().equals(""))
        {
            Member _member = memberService.getUser(member);
            if (_member.getLogin() != null) {
                return true;
            }
        }
        return false;
    }
}
