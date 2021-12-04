package com.rbfactory.bbscore.controller;

import com.rbfactory.bbscore.model.location.Location;
import com.rbfactory.bbscore.service.location.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LocationController {
    public static final String ALL_LOCATION_ENDPOINT = "/locations";
    public static final String SINGLE_LOCATION_ENDPOINT = "/location";

    private final LocationService locationService;

    @GetMapping(ALL_LOCATION_ENDPOINT)
    public List<Location> getLocations(){
        return locationService.getAllLocation();
    }

    @GetMapping(SINGLE_LOCATION_ENDPOINT)
    public Location getLocation(@RequestParam String name){
        return locationService.getLocation(name);
    }

    @PostMapping(SINGLE_LOCATION_ENDPOINT)
    public void updateLocation(@RequestParam Location updatedLocation){
        locationService.updateLocation(updatedLocation);
    }
}
