package com.learningspringboot.firstspringbootapp.controller;


import com.learningspringboot.firstspringbootapp.entity.Post;
import com.learningspringboot.firstspringbootapp.entity.User;
import com.learningspringboot.firstspringbootapp.model.PostRequestModel;
import com.learningspringboot.firstspringbootapp.repository.PostRepository;
import com.learningspringboot.firstspringbootapp.service.PostService;
import com.learningspringboot.firstspringbootapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PostController {

    @Autowired
    PostService postServiceImpl;

    @Autowired
    UserService userService;

    @PostMapping(path = "/savepost/{userId}")
    public ResponseEntity<Map<String, Post>> savePost(@PathVariable String userId,@RequestBody PostRequestModel postrequestbody){
        User fetchedUser = userService.getUserById(Long.parseLong(userId));
       Post post =  new Post(postrequestbody.getImage_url(),postrequestbody.getCaption(),postrequestbody.getDescription(),postrequestbody.getLikes(),postrequestbody.getDocument_url(),fetchedUser);
       System.out.println(post.getUser().getUser_name());
       Post savedPost =  postServiceImpl.savePost(post);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "post",savedPost
        ));
    }

}
