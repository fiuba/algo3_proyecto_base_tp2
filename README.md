![tp2](https://github.com/fiuba/algo3_proyecto_base_tp2/actions/workflows/build.yml/badge.svg) [![codecov](https://codecov.io/gh/fiuba/algo3_proyecto_base_tp2/branch/master/graph/badge.svg)](https://codecov.io/gh/fiuba/algo3_proyecto_base_tp2)


# TP2 Algoritmos 3: {nombre}

Trabajo Práctico número 2 de la materia Algoritmos y Programación III de FIUBA

## Grupo {N}

* **Integrante 1** - [integrante1](https://github.com/integrante1)
* **Integrante 2** - [integrante2](https://github.com/integrante2)
* **Integrante 3** - [integrante3](https://github.com/integrante3)
* **Integrante 4** - [integrante4](https://github.com/integrante4)

Corrector: **{Corrector}**

## Empaquetado

Cuando se genera un **tag** que comienza con `v` (ejemplo `v0.0.1`) automáticamente se produce un [release](https://github.com/fiuba/algo3_proyecto_base_tp2/releases) con la aplicación empaquetada. Para el nombre de la versión se recomienda utilizar [versionado semántico](https://semver.org/lang/es/), por ejemplo:

```bash
$ git tag v0.0.1   # Genera el tag sobre el commit actual
$ git push --tags  # Pushea el tag al repo, iniciando el release automático
```

Para más información sobre cómo generar tags ver la [documentación de git](https://git-scm.com/book/es/v2/Fundamentos-de-Git-Etiquetado).

## Distribución

El archivo `.jar` generado en el release contiene la aplicación empaquetada y puede distribuirse. Luego puede ejecutarse en Windows, Mac o Linux con:

```bash
$ java -jar <archivo.jar>
```

## Desarrollo

Existen distintas maneras de configurar el ambiente de desarrollo:

- [Docker](docs/Docker.md)
- [Nativo](docs/Nativo.md)
- Adicionalmente se puede configurar el IDE [IntelliJ](docs/IntelliJ.md)

## Licencia

Este repositorio se encuentra bajo la Licencia MIT.


