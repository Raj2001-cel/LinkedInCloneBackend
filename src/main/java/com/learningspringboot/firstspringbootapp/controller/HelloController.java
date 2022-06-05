package com.learningspringboot.firstspringbootapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//    @RequestMapping(value = "/",method = RequestMethod.GET)
    @GetMapping("/")
    public String getGreeting(){
        return "hello this is fourth endpoint";
    }
}
