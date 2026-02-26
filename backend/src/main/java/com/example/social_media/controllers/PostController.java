package com.example.social_media.controllers;

import com.example.social_media.entities.Post;
import com.example.social_media.entities.dto.PostRequest;
import com.example.social_media.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> registerPost(@RequestBody PostRequest postRequest) {
        Post post = new Post(null, postRequest.message(), 0, Instant.now(), postRequest.filePath(), postRequest.parentId());
        postService.insert(post);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping
    public Page<Post> getPost(Pageable pageable) {
        return postService.searchPost(pageable);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable UUID id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
