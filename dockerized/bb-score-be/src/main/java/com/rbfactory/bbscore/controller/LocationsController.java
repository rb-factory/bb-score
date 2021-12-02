package com.rbfactory.bbscore.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationsController {

    @GetMapping("")
    public List<Object> getLocations(){
        throw new UnsupportedOperationException();
    }

    @GetMapping("")
    public Object getLocation(String name){
        throw new UnsupportedOperationException();
    }

    @PostMapping("")
    public void updateLocation(Object updatedLocation){
        throw new UnsupportedOperationException();
    }
}
