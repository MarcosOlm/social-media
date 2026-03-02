package com.example.social_media.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_like")
public class Like implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "fk_postId")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "fk_userId")
    private User user;

    public Like() {
    }

    public Like(UUID id, Post post, User user) {
        this.id = id;
        this.post = post;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
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
        Like like = (Like) o;
        return Objects.equals(id, like.id) && Objects.equals(post, like.post) && Objects.equals(user, like.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, post, user);
    }
}
