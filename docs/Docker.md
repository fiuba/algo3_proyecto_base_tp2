# Docker

Esta guia presenta los pasos necesarios para configurar el ambiente de desarrollo utilizando Docker.

## Pre-requisitos

Lista de herramientas necesarias:

1. [docker](https://docs.docker.com/get-docker/)
1. [docker-compose](https://docs.docker.com/compose/install/)

### Levantando el contenedor

```bash
$ docker/up.sh   # En Linux/Max
$ docker\up.cmd  # En Windows
```

Una vez dentro del contenedor, podemos ejecutar los siguientes comandos (es un contenedor linux):

### Ejecutando las pruebas

```bash
$ scripts/build.sh
```

Este comando crea el reporte de cobertura para CI y el reporte HTML que pueden abrir de la siguiente manera:

```bash
$ <browser> ./target/site/jacoco/index.html
```

### Empaquetando la aplicación

```bash
$ scripts/package.sh
```

Luego (desde afuera del contenedor) podemos ejecutar la aplicación con:

```bash
$ java -jar target/tp2-1.0-SNAPSHOT.jar
```

### Deteniendo el contenedor

```bash
$ docker/down.sh   # En Linux/Max
$ docker\down.cmd  # En Windows
```


