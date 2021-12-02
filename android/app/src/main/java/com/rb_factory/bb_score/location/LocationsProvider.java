package com.rb_factory.bb_score.location;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.Provider;
import com.rb_factory.bb_score.deserializer.JacksonDeserializer;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationsProvider extends Provider<Location> {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public LocationsProvider(InputStream inputStream) {
        super(new JacksonDeserializer<Location>(inputStream, Location.class));
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

    public String[] getAllId() {
        return map.keySet().toArray(new String[0]);
    }
}
