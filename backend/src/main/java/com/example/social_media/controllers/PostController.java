package com.example.social_media.controllers;

import com.example.social_media.entities.Post;
import com.example.social_media.entities.dto.AllPostResponse;
import com.example.social_media.entities.dto.PostRequest;
import com.example.social_media.entities.dto.PostResponse;
import com.example.social_media.entities.mapper.PostMapper;
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

    @PostMapping
    public ResponseEntity<Post> registerPost(@RequestBody PostRequest postRequest) {
        Post post = PostMapper.DtoToPost(postRequest);
        postService.insert(post);
        return ResponseEntity.ok().body(post);
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
