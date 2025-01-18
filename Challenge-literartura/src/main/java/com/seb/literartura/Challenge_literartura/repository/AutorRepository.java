package com.seb.literartura.Challenge_literartura.repository;


import com.seb.literartura.Challenge_literartura.domain.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE a.añoDeNacimiento <= :año AND a.añoDeFallecimiento > :año")
    List<Autor> obtenerAutoresVivosPorAño(int año);
}
