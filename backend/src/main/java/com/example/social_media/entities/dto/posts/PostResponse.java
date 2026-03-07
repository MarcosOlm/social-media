package com.example.social_media.entities.dto.posts;

import com.example.social_media.entities.Post;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class PostResponse {

    private UUID id;
    private String menssage;
    private Integer quantLike;
    private Integer commentCount;
    private Instant creationTime;
    private String filePath;
    private PostWithoutComment parentId;
    private boolean isLiked;
    private String createUser;
    Set<PostWithoutComment> comments = new HashSet<>();

    public PostResponse(UUID id, String menssage, Integer quantLike, Integer commentCount, Instant creationTime, String filePath, Post parentId, boolean isLiked, String createUser, Set<Post> comments) {
        this.id = id;
        this.menssage = menssage;
        this.quantLike = quantLike;
        this.commentCount = commentCount;
        this.creationTime = creationTime;
        this.filePath = filePath;
        this.isLiked = isLiked;
        this.createUser = createUser;

        // null point prevent
        PostWithoutComment p = null;
        if (parentId != null) {
            p = new PostWithoutComment(parentId);
        }
        this.parentId = p;
        this.comments = comments.stream().map(post -> post != null ? new PostWithoutComment(post) : null).collect(Collectors.toSet());
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

    public void setParentId(PostWithoutComment parentId) {
        this.parentId = parentId;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Set<PostWithoutComment> getComments() {
        return comments;
    }

    public void setComments(Set<PostWithoutComment> comments) {
        this.comments = comments;
    }
}
