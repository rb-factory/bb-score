package com.rbfactory.bbscore.service.location;

import com.rbfactory.bbscore.model.location.Location;

import java.util.List;

public interface LocationService {

    List<Location> getAllLocation();

    Location getLocation(String name);

    void updateLocation(Location location);
}
