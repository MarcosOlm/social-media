package com.example.social_media.services;

import com.example.social_media.entities.Like;
import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;
import com.example.social_media.repositories.LikeRepository;
import com.example.social_media.services.exceptions.ResourceAlreadyExist;
import com.example.social_media.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    LikeRepository likeRepository;

    public Like findLikedPost(Post post, User user){
        return likeRepository.findByPostAndUser(post, user).orElseThrow(() -> new ResourceNotFoundException(post.getId()));
    }

    public Like insert(Like like) {
        Optional<Like> isNotLiked = likeRepository.findByPostAndUser(like.getPost(), like.getUser());
        if (isNotLiked.isPresent()) {
            throw new ResourceAlreadyExist(isNotLiked.get().getId());
        }
        return likeRepository.save(like);
    }

    public void delete(Like like) {
        likeRepository.delete(like);
    }
}
