package com.example.social_media.entities.dto.posts;

import com.example.social_media.entities.Post;

import java.time.Instant;
import java.util.UUID;

public class AllPostResponse {

    private UUID id;
    private String menssage;
    private Integer quantLike;
    private Integer commentCount;
    private Instant creationTime;
    private String filePath;
    private boolean isLiked;
    private PostWithoutComment parentId;

    public AllPostResponse(UUID id, String menssage, Integer quantLike, Integer commentCount, Instant creationTime, String filePath, boolean isLiked, Post parentId) {
        this.id = id;
        this.menssage = menssage;
        this.quantLike = quantLike;
        this.commentCount = commentCount;
        this.creationTime = creationTime;
        this.filePath = filePath;
        this.isLiked = isLiked;

        // null point prevent
        PostWithoutComment p = null;
        if (parentId != null) {
            p = new PostWithoutComment(parentId);
        }
        this.parentId = p;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }

    public Integer getQuantLike() {
        return quantLike;
    }

    public void setQuantLike(Integer quantLike) {
        this.quantLike = quantLike;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public PostWithoutComment getParentId() {
        return parentId;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public void setParentId(PostWithoutComment parentId) {
        this.parentId = parentId;
    }
}
