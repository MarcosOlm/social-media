package com.example.social_media.entities.mapper;

import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;
import com.example.social_media.entities.dto.posts.AllPostResponse;
import com.example.social_media.entities.dto.posts.PostRequest;
import com.example.social_media.entities.dto.posts.PostResponse;

import java.time.Instant;

public class PostMapper {

    public static Post DtoToPost(PostRequest postRequest, Post post, User user) {
        return new Post(null, postRequest.message(), Instant.now(), postRequest.filePath(), post, user);
    }

    public static PostResponse PostToDtoWithoutComment(Post post) {
        return new PostResponse(post.getId(), post.getMenssage(), post.getQuantLike(), post.getCommentCount(), post.getCreationTime(), post.getFilePath(), post.getParentId(), post.getComments());
    }

    public static AllPostResponse AllPostToDtoWithoutComment(Post post) {
        return new AllPostResponse(post.getId(), post.getMenssage(), post.getQuantLike(), post.getCommentCount(), post.getCreationTime(), post.getFilePath(), post.getParentId());
    }
}
