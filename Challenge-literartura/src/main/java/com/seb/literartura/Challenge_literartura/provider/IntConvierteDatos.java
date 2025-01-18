package com.seb.literartura.Challenge_literartura.provider;

public interface IntConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
