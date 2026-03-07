package com.example.social_media.entities.dto.posts;

import com.example.social_media.entities.Post;

import java.time.Instant;
import java.util.UUID;

class PostWithoutComment {

    private UUID id;
    private String menssage;
    private Integer quantLike;
    private Integer commentCount;
    private Instant creationTime;
    private String filePath;
    private String createUser;
    private UUID parentId;

    public PostWithoutComment(Post post) {
        this.id = post.getId();
        this.menssage = post.getMenssage();
        this.quantLike = post.getQuantLike();
        this.commentCount = post.getCommentCount();
        this.creationTime = post.getCreationTime();
        this.filePath = post.getFilePath();
        this.createUser = post.getCreator();
        UUID parentId = null;
        if (post.getParentId() != null) {
            parentId = post.getParentId().getId();
        }
        this.parentId = parentId;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }
}
