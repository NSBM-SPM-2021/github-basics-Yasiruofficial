package com.nsbm.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/home")
public class HomeController {

    @GetMapping("/")
    public String getValidity(){
        return "Working";
    }
}
