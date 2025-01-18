package com.seb.literartura.Challenge_literartura;

import com.seb.literartura.Challenge_literartura.domain.AutorDto;
import com.seb.literartura.Challenge_literartura.domain.LibroDto;
import com.seb.literartura.Challenge_literartura.model.Datos;
import com.seb.literartura.Challenge_literartura.model.DatosLibro;
import com.seb.literartura.Challenge_literartura.domain.entity.Idioma;
import com.seb.literartura.Challenge_literartura.service.AutorService;
import com.seb.literartura.Challenge_literartura.provider.ConsumoAPI;
import com.seb.literartura.Challenge_literartura.provider.ConvierteDatos;
import com.seb.literartura.Challenge_literartura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class AppConsole {

    private static final String URL_BASE = "https://gutendex.com/books/";

    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorService autorService;

    @Autowired
    private ConsumoAPI consumoAPI;

    @Autowired
    private ConvierteDatos conversor;

    private final Scanner teclado = new Scanner(System.in);

    public void ejecutarOperaciones() {
        int operacion = -1;
        while (operacion != 0) {
            mostrarMenu();
            try {
                System.out.print("Ingrese una opción: ");
                operacion = Integer.parseInt(teclado.nextLine());
                switch (operacion) {
                    case 1 -> buscarLibroPorTitulo();
                    case 2 -> listarLibrosRegistrados();
                    case 3 -> listarAutoresRegistrados();
                    case 4 -> listarAutoresVivosPorAnio();
                    case 5 -> {
                        mostrarIdiomas();
                        listarLibrosPorIdioma();
                    }
                    case 0 -> System.out.println("Saliendo del programa...");
                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            } catch (Exception e) {
                System.err.println("Ocurrió un error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void mostrarMenu() {
        System.out.println("""
                +++++++++++++++++++++++++++++++++++++++++++++++++++
                +++                Menú Principal               +++
                +++++++++++++++++++++++++++++++++++++++++++++++++++
                +   1- Buscar libro por título                   +
                +   2- Listar libros registrados                 +
                +   3- Listar autores registrados                +
                +   4- Listar autores vivos en un determinado año+
                +   5- Listar libros por idioma                  +
                +++++++++++++++++++++++++++++++++++++++++++++++++++
                +   0- Salir                                     +
                +++++++++++++++++++++++++++++++++++++++++++++++++++
                """);
    }

    public void mostrarIdiomas() {
        System.out.println("Idiomas disponibles:");
        for (Idioma idioma : Idioma.values()) {
            System.out.println("- " + idioma.mostrar());
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.print("Ingrese el nombre del libro que deseas buscar: ");
        String titulo = teclado.nextLine().trim();

        if (titulo.isEmpty()) {
            System.out.println("El título no puede estar vacío. Intente nuevamente.");
            return;
        }

        try {
            String json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + titulo.replace(" ", "+"));
            DatosLibro libroBuscado = conversor.obtenerDatos(json, Datos.class).libros().get(0);
            LibroDto libroNuevo = libroService.guardarLibro(libroBuscado);
            System.out.println("Libro encontrado y guardado: " + libroNuevo);
        } catch (Exception e) {
            System.out.println("No se encontraron resultados para el título ingresado.");
        }
    }

    private void listarLibrosRegistrados() {
        List<LibroDto> librosRegistrados = libroService.obtenerLibros();
        if (librosRegistrados.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos.");
        } else {
            librosRegistrados.forEach(System.out::println);
        }
    }

    private void listarAutoresRegistrados() {
        List<AutorDto> autoresRegistrados = autorService.obtenerAutores();
        if (autoresRegistrados.isEmpty()) {
            System.out.println("No hay autores registrados en la base de datos.");
        } else {
            autoresRegistrados.forEach(System.out::println);
        }
    }

    private void listarAutoresVivosPorAnio() {
        System.out.print("Ingrese el año de los autor(es) vivos que desea buscar: ");
        try {
            int anio = Integer.parseInt(teclado.nextLine());
            List<AutorDto> autoresVivos = autorService.obtenerAutoresVivosPorAño(anio);
            if (autoresVivos.isEmpty()) {
                System.out.println("No se encontraron autores vivos en el año " + anio + ".");
            } else {
                autoresVivos.forEach(System.out::println);
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un año válido.");
        }
    }

    private void listarLibrosPorIdioma() {
        System.out.print("Escriba el idioma deseado: ");
        String abreviatura = teclado.nextLine().trim();

        try {
            Idioma idioma = Idioma.fromString(abreviatura);
            List<LibroDto> librosPorIdioma = libroService.obtenerLibrosPorIdioma(idioma);
            if (librosPorIdioma.isEmpty()) {
                System.out.println("No se encontraron libros en el idioma: " + abreviatura);
            } else {
                librosPorIdioma.forEach(System.out::println);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Idioma no válido. Intente nuevamente.");
        }
    }
}