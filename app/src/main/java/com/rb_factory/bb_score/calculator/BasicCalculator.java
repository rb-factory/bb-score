package com.rb_factory.bb_score.calculator;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.Player;
import com.rb_factory.bb_score.industry_facility.IndustryFacility;
import com.rb_factory.bb_score.link.Link;
import com.rb_factory.bb_score.location.Location;

import java.util.*;

public class BasicCalculator implements Calculator {
    private HashMap<Player, Integer> scores = new HashMap<>();
    private final HashMap<String, Location> usedLocations;
    private final Set<Link> usedLinks;

    public BasicCalculator(HashMap<String, Location> usedLocations, Set<Link> usedLinks) throws IllegalArgumentException {
        if (usedLocations == null || usedLinks == null) throw new IllegalArgumentException();
        this.usedLocations = usedLocations;
        this.usedLinks = usedLinks;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Map<Player, Integer> calculatePoints() {
        calculateBasePoints();
        calculateLinkPoints();
        return scores;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void calculateLinkPoints() {
        for(Link link: usedLinks){
            Location[] linkLocations = getLinkLocations(link.getLocations());
            int score = getLinkPoints(linkLocations);
            updatePlayerScore(link.getOwner().get(), score);
        }
    }

    private int getLinkPoints(Location[] linkLocations) {
        int score = 0;
        for(Location location: linkLocations){
            for(IndustryFacility industryFacility: location.getIndustryFacilities()){
                score += industryFacility.getLinkPoint();
            }
        }
        return score;
    }

    private Location[] getLinkLocations(String[] locations) {
        Location[] linkLocations = new Location[locations.length];
        for (int i = 0; i < locations.length; i++){
            linkLocations[i] = usedLocations.get(locations[i]);
        }
        return linkLocations;
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    private void calculateBasePoints() {
        for(Location location: usedLocations.values()){
            calculateBasePoint(location);
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void calculateBasePoint(Location location) {
        for (IndustryFacility industryFacility : location.getIndustryFacilities()) {
            Player key = industryFacility.getOwner().get();
            updatePlayerScore(key, industryFacility.getBasePoint());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void updatePlayerScore(Player player, int scoreIncrement){
        Optional<Integer> oldScore = Optional.ofNullable(scores.get(player));
        oldScore = Optional.of(oldScore.orElse(0));
        scores.put(player, oldScore.get() + scoreIncrement);
    }
}
