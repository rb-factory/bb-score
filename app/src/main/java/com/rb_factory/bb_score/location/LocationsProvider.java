package com.rb_factory.bb_score.location;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.Provider;
import com.rb_factory.bb_score.deserializer.JacksonDeserializer;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationsProvider extends Provider<Location> {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public LocationsProvider(File file) {
        super(new JacksonDeserializer<>(file, Location.class));
    }

    @Override
    protected Map<String, Location> loadData() {
        Map<String, Location> map = new HashMap<>();
        List<Location> elements = deserializer.get();
        for (Location element : elements) {
            map.put(element.getID(), element);
        }
        return map;
    }
}
