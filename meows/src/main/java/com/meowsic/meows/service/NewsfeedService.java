package com.meowsic.meows.service;

import com.meowsic.meows.payload.PostDto;
import com.meowsic.meows.payload.PostResponse;

import java.util.List;

public interface NewsfeedService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePostById(long id);
//    List<PostDto> getPostsByCategory(Long categoryId);
}
