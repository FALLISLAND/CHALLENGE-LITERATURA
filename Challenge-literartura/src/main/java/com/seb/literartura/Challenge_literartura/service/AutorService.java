package com.seb.literartura.Challenge_literartura.service;

import com.seb.literartura.Challenge_literartura.domain.AutorDto;
import com.seb.literartura.Challenge_literartura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public List<AutorDto> obtenerAutores() {
        return repository.findAll().stream()
                .map(autor -> new AutorDto(autor))
                .toList();
    }

    public List<AutorDto> obtenerAutoresVivosPorAño(int anio) {
        return repository.obtenerAutoresVivosPorAño(anio).stream()
                .map(autor -> new AutorDto(autor))
                .toList();
    }
}