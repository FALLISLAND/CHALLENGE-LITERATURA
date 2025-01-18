package com.seb.literartura.Challenge_literartura.repository;

import com.seb.literartura.Challenge_literartura.domain.entity.Idioma;
import com.seb.literartura.Challenge_literartura.domain.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT l FROM Libro l WHERE l.idioma = :idioma")
    List<Libro> obtenerLibrosPorIdioma(Idioma idioma);
    Optional<Libro> findByTitulo(String titulo);
}