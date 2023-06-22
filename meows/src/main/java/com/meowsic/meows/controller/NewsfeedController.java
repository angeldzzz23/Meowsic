package com.meowsic.meows.controller;

import com.meowsic.meows.payload.PostDto;
import com.meowsic.meows.payload.PostResponse;
import com.meowsic.meows.service.NewsfeedService;
import com.meowsic.meows.utils.AppConstants;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/newsfeed")
public class NewsfeedController {

//    private PostRepository postRepository

    private NewsfeedService newsfeedService;

    public NewsfeedController(NewsfeedService newsfeedService) {
        this.newsfeedService = newsfeedService;
    }


    @PostMapping
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(newsfeedService.createPost(postDto), HttpStatus.CREATED);
    }

    // getting all of the posts
    @GetMapping
    public PostResponse getAllPost(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value ="sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        return newsfeedService.getAllPosts(pageNo, pageSize,sortBy, sortDir);
    }




}
