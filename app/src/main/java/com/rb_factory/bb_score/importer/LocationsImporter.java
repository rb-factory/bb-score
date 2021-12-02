package com.rb_factory.bb_score.importer;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.importer.deserializer.JacksonDeserializer;
import com.rb_factory.bb_score.model.location.Location;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationsImporter extends Importer<Location> {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public LocationsImporter(InputStream inputStream) {
        super(new JacksonDeserializer<>(inputStream, Location.class));
    }

    @Override
    protected Map<String, Location> importData() {
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
