package com.learningspringboot.firstspringbootapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.learningspringboot.firstspringbootapp.FirstspringbootappApplication;
import com.learningspringboot.firstspringbootapp.entity.User;
import com.learningspringboot.firstspringbootapp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.json.JSONObject;
import org.json.JSONArray;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FirstspringbootappApplication.class)
@AutoConfigureMockMvc
class UserControllerTest extends AbstractTest{

    @Autowired
    UserRepository userRepository;

    @Autowired
    MockMvc mockMvc;
    @Test
    void signUp() throws Exception{

        User customer = User.builder().user_name("rajmourya5").first_Name("rajmourya5").pass_word("hello")
                .confirm_Password("hello").dateOf_Birth(1355270400000L).build();


        mockMvc.perform(post("/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customer))//Call to other method to transform an object to a JSON
        )
                .andExpect(status().isOk());
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAllUser() throws Exception {
        MvcResult mvcResult =  mockMvc.perform(get("/allUser")).andReturn();
        String content  = mvcResult.getResponse().getContentAsString();
        User[] userslist =  super.mapFromJson(content,User[].class);
        assertTrue(userslist.length>0);
    }



    @Test
    void getUserById() throws Exception{
        MvcResult mvcResult =  mockMvc.perform(get("/getuserbyid/1")).andReturn();
        int status =  mvcResult.getResponse().getStatus();
        assertTrue(status==200);
        String content  = mvcResult.getResponse().getContentAsString();
        Gson gson = new Gson();
        JsonObject json =  new JsonParser().parse(content).getAsJsonObject();
        System.out.println(json);
        assertThat(json.get("user_name").getAsString()).isEqualTo("rajmourya5");

    }
}