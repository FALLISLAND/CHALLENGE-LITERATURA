# Challenge-Literalura

## LiterAlura-Challenge

Este proyecto fue creado como parte de mi proceso de aprendizaje. El objetivo principal era integrar la API Gutendex y almacenar los resultados en una base de datos PostgreSQL. El enfoque del proyecto se centra en funcionalidades específicas que permiten realizar operaciones básicas de gestión de libros.

---

## Características

El proyecto incluye las siguientes funcionalidades:

- **Buscar Libro:** Permite buscar libros por título utilizando la API de Gutendex y guarda el primer resultado encontrado en la base de datos.
- **Listar Libros:** Muestra por consola todos los libros guardados en la base de datos.
- **Listar Autores:** Muestra por consola todos los autores guardados en la base de datos.
- **Listar Autores vivos en determinado año:** Imprime por consola los autores que estaban vivos en un año específico, basado en la información almacenada en la base de datos.
- **Listar Libros por Idioma:** Muestra en consola todos los libros que coinciden con el idioma buscado.

---

## Requisitos

Para ejecutar este proyecto, se requieren las siguientes tecnologías y herramientas:

1. **Java JDK:** Versión 17 o superior, disponible en [Download the Latest Java LTS](https://www.oracle.com/java/technologies/javase-downloads.html).
2. **Maven:** Versión 4 o superior, para la gestión de dependencias y construcción del proyecto.
3. **Spring Boot:** Versión 3.3.0, configurado a través de [Spring Initializr](https://start.spring.io/).
4. **PostgreSQL:** Versión 14.12 o superior, como base de datos relacional. Configurado y conectado con SQL.
5. **IDE:** Se recomienda IntelliJ IDEA, disponible en [JetBrains](https://www.jetbrains.com/idea/), para el desarrollo integrado del proyecto.

---

## Dependencias para agregar al crear el proyecto en Spring Initializr

- **Spring Data JPA:** Para la integración con la capa de persistencia.
- **PostgreSQL Driver:** Para la conexión con la base de datos PostgreSQL.
- **Jackson:** Para el manejo de JSON.

---

## Menú Principal de la Aplicación

```plaintext
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

## Funcionalidades

1. **Buscar libro por título**
   - Permite buscar un libro en la API de Gutendex.
   - Al encontrar el libro, lo guarda en la base de datos.

2. **Listar libros registrados**
   - Muestra todos los libros almacenados en la base de datos.

3. **Listar autores registrados**
   - Muestra todos los autores registrados en la base de datos.

4. **Listar autores vivos en un año**
   - Permite ingresar un año específico y muestra los autores que estaban vivos durante ese tiempo.

5. **Listar libros por idioma**
   - Muestra todos los libros que coinciden con el idioma buscado.

---

## Dependencias Principales

Agrega las siguientes dependencias al archivo `pom.xml` al crear el proyecto en Spring Initializr:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
    </dependency>
</dependencies>

