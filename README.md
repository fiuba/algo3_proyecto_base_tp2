![tp2](https://github.com/fiuba/algo3_proyecto_base_tp2/actions/workflows/build.yml/badge.svg) [![codecov](https://codecov.io/gh/fiuba/algo3_proyecto_base_tp2/branch/master/graph/badge.svg)](https://codecov.io/gh/fiuba/algo3_proyecto_base_tp2)


# TP2 Algoritmos 3: {nombre}

Trabajo Práctico número 2 de la materia Algoritmos y Programación III de FIUBA

## Grupo {N}

* **Integrante 1** - [integrante1](https://github.com/integrante1)
* **Integrante 2** - [integrante2](https://github.com/integrante2)
* **Integrante 3** - [integrante3](https://github.com/integrante3)
* **Integrante 4** - [integrante4](https://github.com/integrante4)

Corrector: **{Corrector}**

## Empaquetamiento

Cuando se genera un **tag** que comienza con `v` (ejemplo `v0.0.1`) automáticamente se produce un [release](./releases) con la aplicación empaquetada. Para el nombre de la versión se recomienda utilizar [versionado semántico](https://semver.org/lang/es/), por ejemplo:

```bash
$ git tag v0.0.1 "La mejor versión hasta el momento"  # Genera el tag sobre el commit actual
$ git push --tags  # Pushea el tag al repo, lo que genera el release automático
```

## Distribución

El archivo `.jar` generado en el release contiene la aplicación empaquetada y puede distribuirse. Luego puede ejecutarse en Windos, Mac o Linux con:

```bash
$ java -jar <archivo.jar>
```

## Desarrollo

Existen distintas maneras de configurar el ambiente de desarrollo:

- [Docker](docs/Docker.md)
- [Nativa](docs/Nativa.md)

## Licencia

Este repositorio está bajo la Licencia MIT


