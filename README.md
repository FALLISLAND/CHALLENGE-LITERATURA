<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Challenge-Literartura</title>
</head>
<body>
    <h1>Challenge-Literartura</h1>

    <h2>Descripción del Proyecto</h2>
    <p>
        El proyecto <strong>Challenge-Literartura</strong> es una aplicación de consola desarrollada en Java utilizando <strong>Spring Boot</strong>.
        Permite interactuar con la API de Gutendex para buscar y gestionar libros y autores. Entre sus características principales se encuentran:
    </p>
    <ul>
        <li>Buscar libros por título y guardarlos en una base de datos.</li>
        <li>Listar libros y autores registrados.</li>
        <li>Listar autores vivos en un año específico.</li>
        <li>Listar libros por idioma.</li>
        <li>Interactuar a través de un menú en la consola.</li>
    </ul>

    <h2>Estructura del Proyecto</h2>
    <pre>
src/main/java
├── com.seb.literartura.Challenge_literartura
│   ├── AppConsole.java               # Clase principal para la interacción por consola
│   ├── ChallengeLiteraluraApplication.java  # Clase principal de Spring Boot
│   ├── domain                       # DTOs y clases de dominio
│   ├── model                        # Modelos para la conversión de datos
│   ├── repository                   # Interfaces de repositorios JPA
│   ├── service                      # Servicios principales (LibroService, AutorService)
│   └── provider                     # Clases auxiliares para consumo y conversión de datos
    </pre>

    <h2>Tecnologías Utilizadas</h2>
    <ul>
        <li><strong>Java 17 o superior</strong></li>
        <li><strong>Spring Boot 3.2</strong></li>
        <li><strong>Spring Data JPA</strong></li>
        <li><strong>PostgreSQL</strong></li>
        <li><strong>Maven</strong></li>
        <li><strong>Gutendex API</strong> (<a href="https://gutendex.com/">https://gutendex.com/</a>)</li>
    </ul>

    <h2>Requisitos Previos</h2>
    <ul>
        <li><strong>JDK:</strong> Asegúrate de tener instalado JDK 17 o superior.</li>
        <li><strong>PostgreSQL:</strong> Configura una base de datos PostgreSQL y anota las credenciales.</li>
        <li><strong>Maven:</strong> Debes tener Maven configurado para compilar el proyecto.</li>
    </ul>

    <h2>Configuración del Proyecto</h2>
    <h3>Paso 1: Clonar el Repositorio</h3>
    <pre>
git clone https://github.com/tu-usuario/challenge-literartura.git
cd challenge-literartura
    </pre>

    <h3>Paso 2: Configurar la Base de Datos</h3>
    <p>Crea una base de datos PostgreSQL llamada <code>literatura</code> y anota las credenciales:</p>
    <pre>
CREATE DATABASE literatura;
    </pre>

    <h3>Paso 3: Configurar <code>application.properties</code></h3>
    <p>Edita el archivo <code>src/main/resources/application.properties</code> con las credenciales de tu base de datos:</p>
    <pre>
spring.datasource.url=jdbc:postgresql://localhost:5432/literatura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    </pre>

    <h3>Paso 4: Compilar el Proyecto</h3>
    <pre>
mvn clean install
    </pre>

    <h3>Paso 5: Ejecutar la Aplicación</h3>
    <pre>
mvn spring-boot:run
    </pre>

    <h2>Uso de la Aplicación</h2>
    <p>Una vez iniciada, interactúa con la consola siguiendo las opciones del menú principal:</p>
    <pre>
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
    </pre>

    <h2>Funcionalidades</h2>
    <ol>
        <li>
            <strong>Buscar libro por título</strong>
            <ul>
                <li>Permite buscar un libro en la API de Gutendex.</li>
                <li>Al encontrar el libro, lo guarda en la base de datos.</li>
            </ul>
        </li>
        <li><strong>Listar libros registrados</strong></li>
        <li><strong>Listar autores registrados</strong></li>
        <li><strong>Listar autores vivos en un año</strong></li>
        <li><strong>Listar libros por idioma</strong></li>
    </ol>

    <h2>Dependencias Principales</h2>
    <pre>
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
    </pre>
</body>
</html>
