package com.rb_factory.bb_score.merchant_point;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.rb_factory.bb_score.Provider;
import com.rb_factory.bb_score.deserializer.JacksonDeserializer;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MerchantPointsProvider extends Provider<MerchantPoint> {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public MerchantPointsProvider(File json) {
        super(new JacksonDeserializer<>(json, MerchantPoint.class));
    }

    @Override
    protected Map<String, MerchantPoint> loadData() {
        Map<String, MerchantPoint> map = new HashMap<>();
        List<MerchantPoint> elements = deserializer.get();
        for (MerchantPoint element : elements) {
            map.put(element.getID(), element);
        }
        return map;
    }
}
