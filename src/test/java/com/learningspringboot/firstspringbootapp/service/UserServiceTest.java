package com.learningspringboot.firstspringbootapp.service;

import com.learningspringboot.firstspringbootapp.entity.User;
import com.learningspringboot.firstspringbootapp.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock private UserRepository userRepository;


    private UserService underTests;

    private User user;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
      user =  User.builder().id(2L).user_name("rajmourya7").first_Name("rajmourya8").pass_word("hello9")
              .confirm_Password("hello9").dateOf_Birth(1355270400000L).build();
      underTests =  new UserServiceImpl(userRepository);
    }




    @Test
    void getAllUser() {
        underTests.getAllUser();
        verify(userRepository).findAll();
    }


}