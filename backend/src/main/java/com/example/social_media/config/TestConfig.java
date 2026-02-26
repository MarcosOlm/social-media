package com.example.social_media.config;

import com.example.social_media.entities.Post;
import com.example.social_media.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        Post p1 = new Post(null, "Estudando Java", 5, Instant.now(), null);
        Post p2 = new Post(null, "Estudando Java", 5, Instant.now(), null);
        Post p3 = new Post(null, "Estudando Java", 5, Instant.now(), null);

        postRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
