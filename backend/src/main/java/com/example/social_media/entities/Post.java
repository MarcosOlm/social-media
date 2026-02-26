package com.example.social_media.entities;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_post")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String menssage;
    private Integer quantLike;
    private Instant creationTime;
    @Nullable
    private String filePath;

    public Post() {
    }

    public Post(UUID id, String menssage, Integer quantLike, Instant creationTime, @Nullable String filePath) {
        this.id = id;
        this.menssage = menssage;
        this.quantLike = quantLike;
        this.creationTime = creationTime;
        this.filePath = filePath;
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

    public Integer getLike() {
        return quantLike;
    }

    public void oneMoreLike() {
        this.quantLike += 1;
    }

    public void oneLessLike() {
        this.quantLike -= 1;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    @Nullable
    public String getImgPath() {
        return filePath;
    }

    public void setImgPath(@Nullable String imgPath) {
        this.filePath = imgPath;
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
