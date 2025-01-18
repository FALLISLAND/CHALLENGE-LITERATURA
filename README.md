Challenge-Literartura
Descripción del Proyecto
El proyecto Challenge-Literartura es una aplicación de consola desarrollada en Java utilizando Spring Boot. Permite interactuar con la API de Gutendex para buscar y gestionar libros y autores. Entre sus características principales se encuentran:

Buscar libros por título y guardarlos en una base de datos.
Listar libros y autores registrados.
Listar autores vivos en un año específico.
Listar libros por idioma.
Interactuar a través de un menú en la consola.
Estructura del Proyecto
plaintext
Copiar
Editar
src/main/java
├── com.seb.literartura.Challenge_literartura
│   ├── AppConsole.java               # Clase principal para la interacción por consola
│   ├── ChallengeLiteraluraApplication.java  # Clase principal de Spring Boot
│   ├── domain                       # DTOs y clases de dominio
│   ├── model                        # Modelos para la conversión de datos
│   ├── repository                   # Interfaces de repositorios JPA
│   ├── service                      # Servicios principales (LibroService, AutorService)
│   └── provider                     # Clases auxiliares para consumo y conversión de datos
Tecnologías Utilizadas
Java 17 o superior
Spring Boot 3.2
Spring Data JPA
PostgreSQL
Maven
Gutendex API (https://gutendex.com/)
Requisitos Previos
JDK: Asegúrate de tener instalado JDK 17 o superior.
PostgreSQL: Configura una base de datos PostgreSQL y anota las credenciales.
Maven: Debes tener Maven configurado para compilar el proyecto.
Configuración del Proyecto
Paso 1: Clonar el Repositorio
bash
Copiar
Editar
git clone https://github.com/tu-usuario/challenge-literartura.git
cd challenge-literartura
Paso 2: Configurar la Base de Datos
Crea una base de datos PostgreSQL llamada literatura y anota las credenciales.

Ejemplo:

sql
Copiar
Editar
CREATE DATABASE literatura;
Paso 3: Configurar application.properties
Edita el archivo src/main/resources/application.properties con las credenciales de tu base de datos:

properties
Copiar
Editar
spring.datasource.url=jdbc:postgresql://localhost:5432/literatura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
Paso 4: Compilar el Proyecto
Ejecuta el siguiente comando para compilar el proyecto:

bash
Copiar
Editar
mvn clean install
Paso 5: Ejecutar la Aplicación
Ejecuta el siguiente comando para iniciar la aplicación:

bash
Copiar
Editar
mvn spring-boot:run
Uso de la Aplicación
Una vez iniciada, interactúa con la consola siguiendo las opciones del menú principal:

plaintext
Copiar
Editar
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
Funcionalidades
1. Buscar libro por título
Permite buscar un libro en la API de Gutendex.
Al encontrar el libro, lo guarda en la base de datos.
2. Listar libros registrados
Lista todos los libros almacenados en la base de datos.
3. Listar autores registrados
Muestra todos los autores registrados en la base de datos.
4. Listar autores vivos en un año
Permite ingresar un año y listar los autores que estaban vivos en ese momento.
5. Listar libros por idioma
Filtra y muestra libros según el idioma especificado.
Dependencias Principales
Maven Dependencies
xml
Copiar
Editar
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
