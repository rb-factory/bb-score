package com.rb_factory.bb_score.importer;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.model.link.Link;
import com.rb_factory.bb_score.importer.deserializer.JacksonDeserializer;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LinksImporter extends Importer<Link> {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public LinksImporter(InputStream file) {
        super(new JacksonDeserializer<>(file, Link.class));
    }

    @Override
    protected Map<String, Link> importData() {
        Map<String, Link> map = new HashMap<>();
        List<Link> elements = deserializer.get();
        for (Link element : elements) {
            map.put(element.getID(), element);
        }
        return map;
    }
}
