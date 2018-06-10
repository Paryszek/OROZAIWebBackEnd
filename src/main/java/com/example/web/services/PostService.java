package com.example.web.services;

import com.example.web.entities.Post;
import com.example.web.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public void insert(Post post) {
        postRepository.save(post);
    }
    public Boolean removePost(int id) {
        List<Post> posts = getAllPosts();
        for(Post post : posts) {
            if (post.getId() == id) {
                postRepository.delete(post);
                return true;
            }
        }
        return false;
    }
}