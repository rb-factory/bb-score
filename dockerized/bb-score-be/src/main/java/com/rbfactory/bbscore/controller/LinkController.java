package com.rbfactory.bbscore.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/link")
public class LinkController {

    @GetMapping("")
    public List<Object> getLinks(){
        throw new UnsupportedOperationException();
    }

    @GetMapping("")
    public Object getLink(int id){
        throw new UnsupportedOperationException();
    }

    @PostMapping("")
    public void updateLink(Object link){
        throw new UnsupportedOperationException();
    }
}
