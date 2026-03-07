package com.example.social_media.entities.mapper;

import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;
import com.example.social_media.entities.dto.posts.AllPostResponse;
import com.example.social_media.entities.dto.posts.PostRequest;
import com.example.social_media.entities.dto.posts.PostResponse;
import com.example.social_media.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Instant;

public class PostMapper {

    @Autowired
    private UserRepository userRepository;

    public static Post DtoToPost(PostRequest postRequest, String filePath, Post post, User user) {
        return new Post(null, postRequest.message(), Instant.now(), filePath, post, user);
    }

    public static PostResponse PostToDtoWithoutComment(Post post, User user) {

        return new PostResponse(post.getId(), post.getMenssage(), post.getQuantLike(), post.getCommentCount(), post.getCreationTime(), post.getFilePath(), post.getParentId(), post.getIsLiked(user), post.getComments());
    }

    public static AllPostResponse AllPostToDtoWithoutComment(Post post, User user) {
        return new AllPostResponse(post.getId(), post.getMenssage(), post.getQuantLike(), post.getCommentCount(), post.getCreationTime(), post.getFilePath(), post.getIsLiked(user), post.getParentId());
    }
}
