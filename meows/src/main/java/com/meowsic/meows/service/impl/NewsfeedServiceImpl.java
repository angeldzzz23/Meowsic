package com.meowsic.meows.service.impl;

import com.meowsic.meows.entity.Post;
import com.meowsic.meows.exception.ResourceNotFoundException;
import com.meowsic.meows.payload.PostDto;
import com.meowsic.meows.payload.PostResponse;
import com.meowsic.meows.repository.NewsfeedRepository;
import com.meowsic.meows.service.NewsfeedService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();

        PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Post> posts = newsfeedRepository.findAll(pageable);

        // get content for page object
        List<Post> listOfPosts = posts.getContent();

        List<PostDto> content = listOfPosts.stream().map(post -> mapToDTO(post)).collect(Collectors.toList());

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(content);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getTotalElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());



        return postResponse;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = newsfeedRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("post", "id", id));
        return mapToDTO(post);
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
