package com.rb_factory.bb_score.calculator;

import com.rb_factory.bb_score.Player;
import com.rb_factory.bb_score.exception.NoMoreIndustryFacilityPlaceAtLocationException;
import com.rb_factory.bb_score.exception.NoOwnerAssignedException;
import com.rb_factory.bb_score.exception.NoSuchIndustryFacilityTypeAtLocation;
import com.rb_factory.bb_score.industry_facility.IndustryFacilitiesProvider;
import com.rb_factory.bb_score.industry_facility.IndustryFacility;
import com.rb_factory.bb_score.industry_facility.IndustryFacilityType;
import com.rb_factory.bb_score.location.Location;
import com.rb_factory.bb_score.location.LocationsProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class BasicCalculatorTest {

    private HashMap<String, Location> usedLocations;
    BasicCalculator basicCalculator;
    private final LocationsProvider locationsProvider = new LocationsProvider(new FileInputStream("Locations.json"));
    private final IndustryFacilitiesProvider industryFacilitiesProvider = new IndustryFacilitiesProvider(new File("IndustryFacilities.json"));

    @Test
    void whenNullLocationIsGivenThenIllegalArgumentExceptionThrown() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BasicCalculator(null, new HashSet<>()));
    }

    @Test
    void whenNullLinkIsGivenThenIllegalArgumentExceptionThrown() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new BasicCalculator(usedLocations, null));
    }

    @Test
    void whenOneMineIsInCoalbrookdale() throws NoSuchIndustryFacilityTypeAtLocation, NoMoreIndustryFacilityPlaceAtLocationException, NoOwnerAssignedException {
        IndustryFacility industryFacility = new IndustryFacility(IndustryFacilityType.IRON_WORK, 1, 1, 0);
        industryFacility.setOwner(Player.ORANGE);
        Location location = new Location("COALBROOKDALE", new IndustryFacilityType[][]{{IndustryFacilityType.IRON_WORK, IndustryFacilityType.BREWERY}, {IndustryFacilityType.IRON_WORK}, {IndustryFacilityType.COAL_MINE}});
        location.addIndustryFacility(industryFacility);
        usedLocations.put("COALBROOKDALE", location);
        basicCalculator = new BasicCalculator(usedLocations, new HashSet<>());
        Map<Player, Integer> actual = basicCalculator.calculatePoints();
        Assertions.assertEquals(java.util.Optional.of(1).get(), actual.get((Player) Player.ORANGE));
    }

    @Test
    void moreIndustriesInOneLocation() throws NoSuchIndustryFacilityTypeAtLocation, NoMoreIndustryFacilityPlaceAtLocationException, NoOwnerAssignedException {
        IndustryFacility industryFacility = industryFacilitiesProvider.get("COAL_MINE_1");
        industryFacility.setOwner(Player.ORANGE);
        Location location = locationsProvider.get("COALBROOKDALE");
        location.addIndustryFacility(industryFacility);
        usedLocations.put("COALBROOKDALE", location);
        basicCalculator = new BasicCalculator(usedLocations, new HashSet<>());
        Map<Player, Integer> actual = basicCalculator.calculatePoints();
        Assertions.assertEquals(java.util.Optional.of(1).get(), actual.get((Player) Player.ORANGE));
    }

    @Test
    void moreIndustriesInOneLocation2() throws NoSuchIndustryFacilityTypeAtLocation, NoMoreIndustryFacilityPlaceAtLocationException, NoOwnerAssignedException {
        arrangeUsedLocations(new String[][]{{"COALBROOKDALE", "ORANGE", "COAL_MINE_1"}});
        basicCalculator = new BasicCalculator(usedLocations, new HashSet<>());
        Map<Player, Integer> actual = basicCalculator.calculatePoints();
        Assertions.assertEquals(java.util.Optional.of(1).get(), actual.get((Player) Player.ORANGE));
    }

    private void arrangeUsedLocations(String[][] arr) throws NoMoreIndustryFacilityPlaceAtLocationException, NoOwnerAssignedException, NoSuchIndustryFacilityTypeAtLocation {
        for (int i = 0; i < arr.length; i++) {
            Location location = locationsProvider.get(arr[i][0]);
            for (int j = 2; j < arr[i].length; j++) {
                IndustryFacility industryFacility = industryFacilitiesProvider.get(arr[i][j]);
                industryFacility.setOwner(Player.valueOf(arr[i][1]));
                location.addIndustryFacility(industryFacility);
                usedLocations.put(arr[i][0], location);
            }
        }
    }

    @BeforeEach
    void setUp() {
        this.usedLocations = new HashMap<>();
    }

    @AfterEach
    void tearDown() {
        basicCalculator = null;
        usedLocations = null;
    }
}