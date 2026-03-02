package com.example.social_media.config;

import com.example.social_media.entities.Like;
import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;
import com.example.social_media.repositories.LikeRepository;
import com.example.social_media.repositories.PostRepository;
import com.example.social_media.repositories.UserRepository;
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
    @Autowired
    private LikeRepository likeRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "marcos", "marcos@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u2 = new User(null, "mateus", "mateus@email.com", new BCryptPasswordEncoder().encode("12345"));
        User u3 = new User(null, "joão", "joão@email.com", new BCryptPasswordEncoder().encode("12345"));

        Post p1 = new Post(null, "Estudando Java", Instant.now(), null, null, u2);
        Post p2 = new Post(null, "print('Hello, world')", Instant.now(), null, p1, u1);
        Post p3 = new Post(null, "Estudando rust", Instant.now(), null, null, u3);

        Like l1 = new Like(null, p1, u1);
        Like l2 = new Like(null, p1, u2);
        Like l3 = new Like(null, p2, u1);
        Like l4 = new Like(null, p2, u3);
        Like l5 = new Like(null, p2, u2);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        postRepository.saveAll(Arrays.asList(p1, p2, p3));
        likeRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
    }
}
