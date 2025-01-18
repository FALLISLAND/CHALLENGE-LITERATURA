package com.seb.literartura.Challenge_literartura.service;

import com.seb.literartura.Challenge_literartura.domain.LibroDto;
import com.seb.literartura.Challenge_literartura.model.DatosLibro;
import com.seb.literartura.Challenge_literartura.domain.entity.Idioma;
import com.seb.literartura.Challenge_literartura.domain.entity.Libro;
import com.seb.literartura.Challenge_literartura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository repository;

    public LibroDto guardarLibro(DatosLibro datos) {
        Optional<Libro> libroExistente = repository.findByTitulo(datos.titulo());

        if (libroExistente.isEmpty()) {
            Libro libroNuevo = repository.save(new Libro(datos));
            return new LibroDto(libroNuevo);
        } else {
            System.out.println("El libro ya existe en la base de datos: " + datos.titulo());
            return new LibroDto(libroExistente.get());
        }
    }

    public LibroDto obtenerLibroPorId(Long id) {
        return repository.findById(id)
                .map(LibroDto::new)
                .orElse(null);
    }

    public List<LibroDto> obtenerLibros() {
        return repository.findAll().stream()
                .map(LibroDto::new)
                .toList();
    }

    public List<LibroDto> obtenerLibrosPorIdioma(Idioma idioma) {
        return repository.obtenerLibrosPorIdioma(idioma).stream()
                .map(LibroDto::new)
                .toList();
    }
}