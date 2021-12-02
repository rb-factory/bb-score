package com.rb_factory.bb_score.model;

import com.rb_factory.bb_score.Player;
import com.rb_factory.bb_score.model.link.Link;
import com.rb_factory.bb_score.model.location.Location;

import java.util.List;
import java.util.Map;

public class Game {
    private final Map<Location, List<Link>> locations;
    private final Map<Integer, Player> scores;


    public Game(Map<Location, List<Link>> locations, Map<Integer, Player> scores) {
        this.locations = locations;
        this.scores = scores;
    }

    public List<Link> getLinks(Location location){
        return locations.get(location);
    }

    public Map<Integer, Player> getScores() {
        return scores;
    }

    public add
}
