package com.example.social_media.controllers;

import com.example.social_media.config.SecurityFilter;
import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;
import com.example.social_media.entities.dto.posts.AllPostResponse;
import com.example.social_media.entities.dto.posts.PostRequest;
import com.example.social_media.entities.dto.posts.PostResponse;
import com.example.social_media.entities.mapper.PostMapper;
import com.example.social_media.repositories.UserRepository;
import com.example.social_media.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<PostResponse> registerPost(@RequestBody PostRequest postRequest) {
        User user = userRepository.findByUsername(SecurityFilter.getUsernameFromContext());
        Post post = postService.findById(postRequest.parentId());
        Post newPost = PostMapper.DtoToPost(postRequest, post, user);
        postService.insert(newPost);
        return ResponseEntity.ok().body(PostMapper.PostToDtoWithoutComment(newPost));
    }

    @GetMapping
    public Page<AllPostResponse> getPost(Pageable pageable) {
        return postService.searchPost(pageable).map(PostMapper::AllPostToDtoWithoutComment);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable UUID id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(PostMapper.PostToDtoWithoutComment(post));
    }
}
