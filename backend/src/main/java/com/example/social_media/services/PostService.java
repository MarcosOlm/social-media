package com.example.social_media.services;

import com.example.social_media.entities.Post;
import com.example.social_media.repositories.PostRepository;
import com.example.social_media.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post insert(Post post) {
        return postRepository.save(post);
    }
    
    public Page<Post> searchPost(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Post findById(UUID id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
