package com.rb_factory.bb_score.industry_facility;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.Provider;
import com.rb_factory.bb_score.deserializer.JacksonDeserializer;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndustryFacilitiesProvider extends Provider<IndustryFacility> {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public IndustryFacilitiesProvider(InputStream json) {
        super(new JacksonDeserializer<>(json, IndustryFacility.class));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected Map<String, IndustryFacility> loadData() {
        Map<String, IndustryFacility> map = new HashMap<>();
        List<IndustryFacility> elements = deserializer.get();
        for (IndustryFacility element : elements) {
            map.put(element.getID(), element);
        }
        return map;
    }
}
