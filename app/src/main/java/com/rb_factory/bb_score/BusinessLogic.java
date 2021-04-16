package com.rb_factory.bb_score;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.industry_facility.IndustryFacilitiesProvider;
import com.rb_factory.bb_score.location.Location;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BusinessLogic {
    private final Set<Location> locations;
    private IndustryFacilitiesProvider industryFacilitiesProvider;
    private final HashMap<Player, Integer> scores = new HashMap<Player, Integer>();

    public BusinessLogic(Set<Location> locations) {
        this.locations = locations;
    }

    public Map<Player, Integer> calculateScore(){
        return scores;
    }

    public static void main(String[] args) {

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void loadAll(){
        loadIndustryFacilities();
        loadLinks();
        loadLocations();
        loadMerchantPoints();
    }

    private void loadMerchantPoints() {
        throw new UnsupportedOperationException();
    }

    private void loadLocations() {
        throw new UnsupportedOperationException();
    }

    private void loadLinks() {
        throw new UnsupportedOperationException();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void loadIndustryFacilities(){
        this.industryFacilitiesProvider = new IndustryFacilitiesProvider(new File("industry_facilities.json"));
    }
}
