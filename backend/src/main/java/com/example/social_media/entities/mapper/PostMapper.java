package com.example.social_media.entities.mapper;

import com.example.social_media.entities.Post;
import com.example.social_media.entities.dto.AllPostResponse;
import com.example.social_media.entities.dto.PostRequest;
import com.example.social_media.entities.dto.PostResponse;

import java.time.Instant;

public class PostMapper {

    public static Post DtoToPost(PostRequest postRequest) {
        return new Post(null, postRequest.message(), 0, Instant.now(), postRequest.filePath(), postRequest.parentId());
    }

    public static PostResponse PostToDtoWithoutComment(Post post) {
        return new PostResponse(post.getId(), post.getMenssage(), post.getQuantLike(), post.getCommentCount(), post.getCreationTime(), post.getFilePath(), post.getParentId(), post.getComments());
    }

    public static AllPostResponse AllPostToDtoWithoutComment(Post post) {
        return new AllPostResponse(post.getId(), post.getMenssage(), post.getQuantLike(), post.getCommentCount(), post.getCreationTime(), post.getFilePath(), post.getParentId());
    }
}
