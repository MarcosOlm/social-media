package com.example.social_media.controllers;

import com.example.social_media.config.FileConfig;
import com.example.social_media.config.SecurityFilter;
import com.example.social_media.entities.Post;
import com.example.social_media.entities.User;
import com.example.social_media.entities.dto.posts.AllPostResponse;
import com.example.social_media.entities.dto.posts.PostRequest;
import com.example.social_media.entities.dto.posts.PostResponse;
import com.example.social_media.entities.mapper.PostMapper;
import com.example.social_media.repositories.UserRepository;
import com.example.social_media.services.PostService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserRepository userRepository;
    private final Path fileLocation;

    public PostController(FileConfig fileConfig) {
        this.fileLocation = Paths.get(fileConfig.getUploadDir()).toAbsolutePath().normalize();
    }

    @PostMapping
    public ResponseEntity<PostResponse> registerPost(@RequestPart(value = "file", required = false) MultipartFile file,
                                                     @RequestPart(value = "PostRequest") PostRequest postRequest) {
        User user = userRepository.findByUsername(SecurityFilter.getUsernameFromContext());
        Post post = null;
        String filePath = null;
        if (postRequest.parentId() != null) {
           post = postService.findById(postRequest.parentId());
        }

        // file logic
        if (!file.isEmpty()) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMddyyyy_HHmmss"));
            String fileName = timestamp + "-" + StringUtils.cleanPath(file.getOriginalFilename());
            try {
                Path targetLocation = fileLocation.resolve(fileName);
                file.transferTo(targetLocation);
                filePath = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/post/image/")
                        .path(fileName)
                        .toUriString();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Post newPost = PostMapper.DtoToPost(postRequest, filePath, post, user);
        postService.insert(newPost);
        return ResponseEntity.status(HttpStatus.CREATED).body(PostMapper.PostToDtoWithoutComment(newPost));
    }

    @GetMapping
    public Page<AllPostResponse> getPost(Pageable pageable) {
        return postService.searchPost(pageable).map(PostMapper::AllPostToDtoWithoutComment);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable UUID id) {
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(PostMapper.PostToDtoWithoutComment(post));
    }

    @GetMapping(value = "/image/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        Path filePath = fileLocation.resolve(fileName).normalize();
        try {
            Resource resource = new UrlResource(filePath.toUri());
            String contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            if (contentType == null) {
                contentType = "application/octet-stream";
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment: filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
