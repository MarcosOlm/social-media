package com.example.social_media.services;

import com.example.social_media.entities.Post;
import com.example.social_media.repositories.PostRepository;
import com.example.social_media.services.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post insert(Post post) {
        return postRepository.save(post);
    }
    
    public Page<Post> searchPost(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    public Post findById(UUID id) {
        Optional<Post> post= postRepository.findById(id);
        return post.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Post likePost(UUID id) {
        Optional<Post> post= postRepository.findById(id);
        if (post.isEmpty()) {
            throw new ResourceNotFoundException(id);
        }
        post.get().oneMoreLike();
        return postRepository.save(post.get());
    }

    public Post removeLikePost(UUID id) {
        Optional<Post> post= postRepository.findById(id);
        if (post.isEmpty()) {
            throw new ResourceNotFoundException(id);
        }
        post.get().oneLessLike();
        return postRepository.save(post.get());
    }
}
