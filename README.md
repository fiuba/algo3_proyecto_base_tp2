![tp2](https://github.com/fiuba/algo3_proyecto_base_tp2/actions/workflows/build.yml/badge.svg) [![codecov](https://codecov.io/gh/fiuba/algo3_proyecto_base_tp2/branch/master/graph/badge.svg)](https://codecov.io/gh/fiuba/algo3_proyecto_base_tp2)


# TP2 Algoritmos 3: {nombre}

Trabajo Práctico número 2 de la materia Algoritmos y Programación III de FIUBA

## Grupo {N}

* **Integrante 1** - [integrante1](https://github.com/integrante1)
* **Integrante 2** - [integrante2](https://github.com/integrante2)
* **Integrante 3** - [integrante3](https://github.com/integrante3)
* **Integrante 4** - [integrante4](https://github.com/integrante4)

Corrector: **{Corrector}**

### Pre-requisitos

Listado de software/herramientas necesarias para el proyecto

1. [docker](https://docs.docker.com/get-docker/)
1. [docker-compose](https://docs.docker.com/compose/install/)

### Levantando el contenedor

```bash
  docker/up.sh
```

Una vez dentro del contenedor, podemos ejecutar los siguientes comandos:

### Ejecutando las pruebas

```bash
    scripts/build.sh
```

o

```bash
    mvn test
```

Este comando crea el reporte de cobertura para CI y el reporte HTML que pueden abrir de la siguiente manera:

```bash
    <browser> ./target/site/jacoco/index.html
```

### Empaquetando la aplicación

```bash
    scripts/package.sh
```

Luego (desde afuera del contenedor) podemos ejecutar la aplicación con:

```bash
    java -jar target/tp2-1.0-SNAPSHOT.jar
```

### Deteniendo el contenedor

```bash
    docker/down.sh
```

## Releases

Simplemente creando un nuevo tag que comience con `v` (ejemplo `v0.0.1`) se creará un release nuevo con dicho nombre de tag. Este incluirá el empaquetado que podrá ser ejecutado en linux, mac y windows.

## Licencia

Este repositorio está bajo la Licencia MIT


