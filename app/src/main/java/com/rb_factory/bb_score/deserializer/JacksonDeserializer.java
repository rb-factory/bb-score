package com.rb_factory.bb_score.deserializer;

import android.os.Build;
import androidx.annotation.RequiresApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JacksonDeserializer<T> implements Deserializer<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private String jsonContent;
    private JavaType genericType;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Deprecated
    public JacksonDeserializer(File json, Class<T> genericType) {
        this.genericType = objectMapper.getTypeFactory().constructCollectionType(List.class, genericType);
    }

    public JacksonDeserializer(String jsonContent, Class<T> genericType) {
        this.jsonContent = jsonContent;
        this.genericType = objectMapper.getTypeFactory().constructCollectionType(List.class, genericType);
    }

    public JacksonDeserializer(InputStream inputStream, Class<T> genericType) {
        this.jsonContent = readFile(inputStream);
        this.genericType = objectMapper.getTypeFactory().constructCollectionType(List.class, genericType);
    }
    
    private String readFile(InputStream inputStream){
        String strJSON;
        StringBuilder buf = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            while ((strJSON = in.readLine()) != null) {
                buf.append(strJSON);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buf.toString();
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
