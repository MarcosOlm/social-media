package com.example.social_media.controllers;

import com.example.social_media.entities.User;
import com.example.social_media.entities.dto.auth.SingInRequest;
import com.example.social_media.entities.dto.auth.SingUpRequest;
import com.example.social_media.entities.dto.auth.SinginResponse;
import com.example.social_media.repositories.UserRepository;
import com.example.social_media.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    TokenService tokenService;
    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/sign-in")
    public ResponseEntity<SinginResponse> login(@RequestBody @Valid SingInRequest singin) {
        UsernamePasswordAuthenticationToken userpassword = new UsernamePasswordAuthenticationToken(singin.username(), singin.password());
        Authentication auth = authenticationManager.authenticate(userpassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new SinginResponse(token));
    }

    @PostMapping(value = "/sign-up")
    public ResponseEntity register(@RequestBody @Valid SingUpRequest singup) {
        if (userRepository.findByUsername(singup.username()) != null) {
            return  ResponseEntity.badRequest().build();
        }

        String encrytedPasswrod = new BCryptPasswordEncoder().encode(singup.password());
        User newUser = new User(null, singup.username(), singup.email(), encrytedPasswrod);
        userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
