package com.example.social_media.config;

import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;
import com.example.social_media.repositories.PostRepository;
import com.example.social_media.repositories.UserRepository;
import com.example.social_media.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        Post p1 = new Post(null, "Estudando Java", 5, Instant.now(), null, null);
        Post p2 = new Post(null, "print('Hello, world')", 9, Instant.now(), null, p1);
        Post p3 = new Post(null, "Estudando rust", 3, Instant.now(), null, null);

        User u1 = new User(null, "marcos", "marcos@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u2 = new User(null, "mateus", "mateus@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u3 = new User(null, "joão", "joão@email.com", new BCryptPasswordEncoder().encode("12345"));

        postRepository.saveAll(Arrays.asList(p1, p2, p3));
        userRepository.saveAll(Arrays.asList(u1, u2, u3));
    }
}
