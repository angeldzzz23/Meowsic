package com.meowsic.meows.service.impl;

import com.meowsic.meows.entity.Post;
import com.meowsic.meows.payload.PostDto;
import com.meowsic.meows.repository.NewsfeedRepository;
import com.meowsic.meows.service.NewsfeedService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

//import org.modelmapper.ModelMapper;
@Service
public class NewsfeedServiceImpl implements NewsfeedService {

    private NewsfeedRepository newsfeedRepository;
    private ModelMapper modelMapper;

    public  NewsfeedServiceImpl(NewsfeedRepository newsfeedRepository, ModelMapper modelMapper) {
        this.newsfeedRepository = newsfeedRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post newPost = newsfeedRepository.save(post);
        // convert entity to Dto
        PostDto postResponse = mapToDTO(newPost);
        return postResponse;
    }

    // mapping
    private  PostDto mapToDTO(Post post) {
        PostDto postDto = modelMapper.map(post, PostDto.class);
        return postDto;
    }


    private Post mapToEntity(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        return post;
    }



}
