package com.example.social_media.services.exceptions;

import java.util.UUID;

public class ResourceAlreadyExist extends RuntimeException {

    public ResourceAlreadyExist(UUID id) {
        super("Resource already exist. id: " + id);
    }
}
