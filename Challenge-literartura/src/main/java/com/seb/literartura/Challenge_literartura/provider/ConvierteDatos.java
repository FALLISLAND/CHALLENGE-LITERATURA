package com.seb.literartura.Challenge_literartura.provider;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ConvierteDatos implements IntConvierteDatos {
    private static ConvierteDatos instance;
    private ObjectMapper objectMapper = new ObjectMapper();

    private ConvierteDatos() {
    }

    public static synchronized ConvierteDatos getInstance() {
        if (instance == null) {
            instance = new ConvierteDatos();
        }
        return instance;
    }

    @Override
    public <T> T obtenerDatos(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json, clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
