package com.example.social_media.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_post")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String menssage;
    private Instant creationTime;
    @Nullable
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Post parentId;

    @OneToMany(mappedBy = "parentId", cascade = CascadeType.ALL)
    @JsonManagedReference
    Set<Post> comments = new HashSet<>();

    @OneToMany(mappedBy = "post")
    Set<Like> likes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "fk_userId")
    private User user;

    public Post() {
    }

    public Post(UUID id, String menssage, Instant creationTime, @Nullable String filePath, Post parentId, User user) {
        this.id = id;
        this.menssage = menssage;
        this.creationTime = creationTime;
        this.filePath = filePath;
        this.parentId = parentId;
        this.user = user;
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

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    @Nullable
    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(@Nullable String filePath) {
        this.filePath = filePath;
    }

    public Post getParentId() {
        return parentId;
    }

    public void setParentId(Post parentId) {
        this.parentId = parentId;
    }

    public Set<Post> getComments() {
        return comments;
    }

    public int getCommentCount() {
        return comments.size();
    }

    public Integer getQuantLike() {
        return likes.size();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
