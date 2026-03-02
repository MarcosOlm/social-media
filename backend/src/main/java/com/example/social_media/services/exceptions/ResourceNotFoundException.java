package com.example.social_media.services.exceptions;

import java.util.UUID;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(UUID id) {
        super("Resouce not found. Id: " + id);
    }
}
