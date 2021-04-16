package com.rb_factory.bb_score.deserializer;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JacksonDeserializer<T> implements Deserializer<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private String jsonContent;
    private JavaType genericType;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public JacksonDeserializer(File json, Class<T> genericType) {
        this.jsonContent = readFile(json);
        this.genericType = objectMapper.getTypeFactory().constructCollectionType(List.class, genericType);

    }

    public JacksonDeserializer(String jsonContent, Class<T> genericType) {
        this.jsonContent = jsonContent;
        this.genericType = objectMapper.getTypeFactory().constructCollectionType(List.class, genericType);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private String readFile(File json) {
        byte[] encoded = new byte[0];
        try {
            encoded = Files.readAllBytes(Paths.get(json.getAbsolutePath()));
            return new String(encoded, StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public List<T> get() {
        List<T> elements = null;
        try {
            elements = objectMapper.readValue(jsonContent, genericType);
        } catch (JsonProcessingException e) {
            e.printStackTrace(); //TODO: do logging
        }
        return elements;
    }
}
