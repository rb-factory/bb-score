package com.rb_factory.bb_score;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.Editable;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.industry_facility.IndustryFacilitiesProvider;
import com.rb_factory.bb_score.link.LinksProvider;
import com.rb_factory.bb_score.location.Location;
import com.rb_factory.bb_score.location.LocationsProvider;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Controller {
    private final Set<Location> locations;
    private final HashMap<Player, Integer> scores = new HashMap<Player, Integer>();
    private AssetManager assets;

    private IndustryFacilitiesProvider industryFacilitiesProvider;
    private LinksProvider linkProvider;
    private LocationsProvider locationProvider;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Controller(Context context) {
        locations = new HashSet<>();
        this.assets = context.getAssets();
        loadAll();
    }

    public Location searchLocation(Editable text) {
        Location location = locationProvider.get(text.toString());
        if (location == null) {
            throw new NoSuchElementException(text.toString());
        }
        return location;
    }

    public Map<Player, Integer> calculateScore() {
        return scores;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void loadAll() {
        try {
            loadIndustryFacilities();
            loadLinks();
            loadLocations();
            //loadMerchantPoints();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMerchantPoints() {
        throw new UnsupportedOperationException();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void loadLocations() throws IOException {
        this.locationProvider = new LocationsProvider(assets.open("Locations.json"));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void loadLinks() throws IOException {
        this.linkProvider = new LinksProvider(assets.open("Links.json"));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void loadIndustryFacilities() throws IOException {
        this.industryFacilitiesProvider = new IndustryFacilitiesProvider(assets.open("IndustryFacilities.json"));
    }

    public String[] getActivePlayers() {
        return new String[0];
    }

    public String[] getLocations() {
        return locationProvider.getAllId();
    }
}
