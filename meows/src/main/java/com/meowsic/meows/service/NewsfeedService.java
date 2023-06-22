package com.meowsic.meows.service;

import com.meowsic.meows.payload.PostDto;

public interface NewsfeedService {
    PostDto createPost(PostDto postDto);

}
