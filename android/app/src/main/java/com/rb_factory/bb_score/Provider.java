package com.rb_factory.bb_score;

import com.rb_factory.bb_score.deserializer.Deserializer;

import java.util.Map;


public abstract class Provider<T> {
    protected final Deserializer<T> deserializer;
    protected final Map<String, T> map;

    public Provider(Deserializer<T> deserializer) {
        this.deserializer = deserializer;
        map = loadData();
    }

    protected abstract Map<String, T> loadData();

    public T get(String id) {
        return map.get(id);
    }
}
