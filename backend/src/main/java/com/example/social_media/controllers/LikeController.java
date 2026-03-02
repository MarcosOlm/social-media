package com.example.social_media.controllers;

import com.example.social_media.config.SecurityFilter;
import com.example.social_media.entities.Like;
import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;
import com.example.social_media.entities.dto.likes.LikeRequest;
import com.example.social_media.repositories.UserRepository;
import com.example.social_media.services.LikeService;
import com.example.social_media.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
public class LikeController {

    @Autowired
    LikeService likeService;
    @Autowired
    PostService postService;
    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/insert")
    public ResponseEntity registerLike(@RequestBody LikeRequest likeRequest) {
        Post post = postService.findById(likeRequest.post());
        User user = userRepository.findByUsername(SecurityFilter.getUsernameFromContext());
        Like newLike = new Like(null, post, user);
        likeService.insert(newLike);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping(value = "/remove")
    public ResponseEntity removeLike(@RequestBody LikeRequest likeRequest) {
        Post post = postService.findById(likeRequest.post());
        User user = userRepository.findByUsername(SecurityFilter.getUsernameFromContext());
        Like likedPost = likeService.findLikedPost(post, user);
        likeService.delete(likedPost);
        return ResponseEntity.ok().build();
    }
}
