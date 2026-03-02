package com.example.social_media.repositories;

import com.example.social_media.entities.Like;
import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LikeRepository extends JpaRepository<Like, UUID> {

    Optional<Like> findByPostAndUser(Post post, User user);
}
