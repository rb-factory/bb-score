package com.rb_factory.bb_score;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.importer.IndustryFacilitiesImporter;
import com.rb_factory.bb_score.model.location.Location;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BusinessLogic {
    private final Set<Location> locations;
    private IndustryFacilitiesImporter industryFacilitiesProvider;
    private final HashMap<Player, Integer> scores = new HashMap<Player, Integer>();

    public BusinessLogic(Set<Location> locations) {
        this.locations = locations;
    }

    public Map<Player, Integer> calculateScore(){
        return scores;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void loadAll() throws FileNotFoundException {
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
    private void loadIndustryFacilities() throws FileNotFoundException {
        this.industryFacilitiesProvider = new IndustryFacilitiesImporter(new FileInputStream(new File("industry_facilities.json")));
    }
}
