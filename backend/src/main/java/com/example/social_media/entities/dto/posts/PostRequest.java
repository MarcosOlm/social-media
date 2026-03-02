package com.example.social_media.entities.dto.posts;

import java.util.UUID;

public record PostRequest(String message, String filePath, UUID parentId) {
}
