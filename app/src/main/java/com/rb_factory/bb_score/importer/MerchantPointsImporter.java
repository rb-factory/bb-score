package com.rb_factory.bb_score.importer;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.importer.deserializer.JacksonDeserializer;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MerchantPointsImporter extends Importer<MerchantPoint> {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public MerchantPointsImporter(File json) {
        super(new JacksonDeserializer<>(json, MerchantPoint.class));
    }

    @Override
    protected Map<String, MerchantPoint> importData() {
        Map<String, MerchantPoint> map = new HashMap<>();
        List<MerchantPoint> elements = deserializer.get();
        for (MerchantPoint element : elements) {
            map.put(element.getID(), element);
        }
        return map;
    }
}
