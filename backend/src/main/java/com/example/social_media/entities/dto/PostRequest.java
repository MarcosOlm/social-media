package com.example.social_media.entities.dto;

import com.example.social_media.entities.Post;

public record PostRequest(String message, String filePath, Post parentId) {
}
