package com.seb.literartura.Challenge_literartura.domain;

import com.seb.literartura.Challenge_literartura.domain.entity.Autor;
import com.seb.literartura.Challenge_literartura.domain.entity.Libro;
import java.util.stream.Collectors;

public record AutorDto(
        String nombre,
        Integer añoDeNacimiento,
        Integer añoDeFallecimiento,
        String librosEscritos
) {
    public AutorDto(Autor autor) {
        this(
                autor.getNombre(),
                autor.getAñoDeNacimiento(),
                autor.getAñoDeFallecimiento(),
                autor.getLibros()
                        .stream()
                        .map(Libro::getTitulo)
                        .collect(Collectors.joining(", "))
        );
    }

    @Override
    public String toString() {
        return """
                Autor: %s
                Fecha de nacimiento: %d
                Fecha de fallecimiento: %d
                Libros: [%s]
                """.formatted(nombre, añoDeNacimiento, añoDeFallecimiento, librosEscritos);
    }
}