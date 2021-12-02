package com.rb_factory.bb_score.industry_facility;

import com.rb_factory.bb_score.Provider;
import com.rb_factory.bb_score.deserializer.JacksonDeserializer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

class IndustryFacilitiesProviderTest {
    private static final String coal_mine_1 = "[{\n" +
            "        \"type\": \"COAL_MINE\",\n" +
            "        \"level\": 1,\n" +
            "        \"basePoint\": 1,\n" +
            "        \"linkPoint\": 1\n" +
            "    }, {\n" +
            "        \"type\": \"COAL_MINE\",\n" +
            "        \"level\": 2,\n" +
            "        \"basePoint\": 1,\n" +
            "        \"linkPoint\": 1\n" +
            "    }\n" +
            "]\n";
    private Provider<IndustryFacility> provider;

    @BeforeEach
    void setUp() {
        JacksonDeserializer<IndustryFacility> deserializer = new JacksonDeserializer<IndustryFacility>(coal_mine_1, IndustryFacility.class);
        provider = new IndustryFacilitiesProvider(new File(coal_mine_1));
    }

    @AfterEach
    void tearDown() {
        provider = null;
    }

    @Test
    void whenIDInsertedPOJOisGiven() {
        IndustryFacility expected = new IndustryFacility(IndustryFacilityType.COAL_MINE, 1, 1, 1);
        Assertions.assertEquals(expected, provider.get("COAL_MINE_1"));
    }
}