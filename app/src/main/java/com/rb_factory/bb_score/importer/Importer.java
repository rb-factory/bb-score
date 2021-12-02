package com.rb_factory.bb_score.importer;

import com.rb_factory.bb_score.importer.deserializer.Deserializer;

import java.util.Map;


public abstract class Importer<T> {
    protected final Deserializer<T> deserializer;
    protected final Map<String, T> map;

    public Importer(Deserializer<T> deserializer) {
        this.deserializer = deserializer;
        map = importData();
    }

    protected abstract Map<String, T> importData();

    public T get(String id) {
        return map.get(id);
    }
}
