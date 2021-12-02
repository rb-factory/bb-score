package com.rb_factory.bb_score.importer.deserializer;


import java.util.List;


public interface Deserializer<T> {
    List<T> get();
}
