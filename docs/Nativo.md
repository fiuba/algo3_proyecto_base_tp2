# Nativa

Esta guia presenta los pasos necesarios para configurar el ambiente de desarrollo de forma nativa.

## Pre-requisitos

- Java 11 ([Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) u [OpenJDK](https://openjdk.java.net/install/))
- [Maven](https://maven.apache.org/)

### 1. Pruebas

Para compilar y correr las pruebas, ubicarse en el mismo directorio que el archivo `pom.xml` e ingresar:

```bash
$ mvn clean test
```

### 2. Ejecutar la aplicación

```shell script
$ mvn clean javafx:run
```

La tarea `clean` se encarga de limpiar archivos de compilaciones anteriores. `javafx:run` compila y ejecuta la aplicación.
