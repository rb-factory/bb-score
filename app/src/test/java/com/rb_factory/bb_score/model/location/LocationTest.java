package com.rb_factory.bb_score.model.location;

import com.rb_factory.bb_score.Player;
import com.rb_factory.bb_score.exception.NoMoreIndustryFacilityPlaceAtLocationException;
import com.rb_factory.bb_score.exception.NoOwnerAssignedException;
import com.rb_factory.bb_score.exception.NoSuchIndustryFacilityTypeAtLocation;
import com.rb_factory.bb_score.model.industry_facility.IndustryFacility;
import com.rb_factory.bb_score.model.industry_facility.IndustryFacilityType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.rb_factory.bb_score.model.industry_facility.IndustryFacilityType.*;

class LocationTest {
    private Location location1;
    private IndustryFacility facility1;
    private IndustryFacility facility2;


    @BeforeEach
    void setUp() {
        location1 = new Location("Lo1", new IndustryFacilityType[][]{{MANUFACTURER}});
        facility1 = new IndustryFacility(IndustryFacilityType.COAL_MINE,
                1,
                1,
                1);
        facility2 = new IndustryFacility(IndustryFacilityType.COAL_MINE,
                2,
                1,
                1);
    }

    @AfterEach
    void tearDown() {
        location1 = null;
        facility1 = null;
        facility2 = null;
    }

    @Test
    void whenLocationIsFullWithIndustryFacilitiesExceptionIsThrown() throws NoMoreIndustryFacilityPlaceAtLocationException, NoOwnerAssignedException, NoSuchIndustryFacilityTypeAtLocation {
        facility1.setOwner(Player.ORANGE);
        facility2.setOwner(Player.PURPLE);
        location1.setSlots(new IndustryFacilityType[][]{{COAL_MINE}});
        location1.addIndustryFacility(facility1);
        Assertions.assertThrows(NoMoreIndustryFacilityPlaceAtLocationException.class, () -> location1.addIndustryFacility(facility2));
    }

    @Test
    void whenIndustryFacilityWantedToBeAddedToLocationButNoOwnerAssignedExceptionIsThrown() {
        Assertions.assertEquals(Optional.empty(), facility1.getOwner());
        Assertions.assertThrows(NoOwnerAssignedException.class, () -> location1.addIndustryFacility(facility1));
    }

    @Test
    void testExceptionRaisedWhenNoSuchIndustryTypeIsFoundAtLocation() {
        location1.setSlots(new IndustryFacilityType[][]{{MANUFACTURER}});
        facility1.setOwner(Player.ORANGE);
        Assertions.assertThrows(NoSuchIndustryFacilityTypeAtLocation.class, () -> location1.addIndustryFacility(facility1));
    }

    @Test
    void doValidBasePointCalculation() throws NoMoreIndustryFacilityPlaceAtLocationException, NoOwnerAssignedException, NoSuchIndustryFacilityTypeAtLocation {
        facility1.setOwner(Player.ORANGE);
        location1.addIndustryFacility(facility1);
        //Map<Player, Integer> baseScores = location1.calculateBasePoints();
        //Assertions.assertEquals(Optional.of(facility1.getBasePoint()).get(), baseScores.get(Player.ORANGE));
    }

    @Test
    void testGetMaxNumberOfIndustryFacilities() {
        IndustryFacilityType[][] slots = new IndustryFacilityType[][]{{MANUFACTURER}, {POTTERY}};
        int expectedLength = slots.length;
        location1.setSlots(slots);
        Assertions.assertEquals(expectedLength, location1.getMaxNumberOfIndustryFacility());
    }



}