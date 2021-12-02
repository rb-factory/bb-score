package com.rb_factory.bb_score.importer;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.model.industry_facility.IndustryFacility;
import com.rb_factory.bb_score.importer.deserializer.JacksonDeserializer;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndustryFacilitiesImporter extends Importer<IndustryFacility> {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public IndustryFacilitiesImporter(InputStream json) {
        super(new JacksonDeserializer<>(json, IndustryFacility.class));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected Map<String, IndustryFacility> importData() {
        Map<String, IndustryFacility> map = new HashMap<>();
        List<IndustryFacility> elements = deserializer.get();
        for (IndustryFacility element : elements) {
            map.put(element.getID(), element);
        }
        return map;
    }
}
