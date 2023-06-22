package com.meowsic.meows.service;

import com.meowsic.meows.payload.PostDto;
import com.meowsic.meows.payload.PostResponse;

public interface NewsfeedService {
    PostDto createPost(PostDto postDto);
    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
}
