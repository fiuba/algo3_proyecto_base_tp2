# Configuración de entorno en IntelliJ

1. En la ventana de inicio de IntelliJ seleccionar `Import`

2. Navegar al directorio clonado y seleccionar el archivo `pom.xml`

![pom.xml](./docs/img/pom_xml.png)

3. Seleccionar `Next` para saltear los pasos de configuración y abrir el entorno. Deberíamos ver algo como lo siguiente:

![Entorno de IntelliJ](./docs/img/entorno.png)

4. Abrir el panel lateral de `Maven`

5. Seleccionar `Reimport All Maven Projects` para descargar las dependencias

![Resolver dependencias via Maven](./docs/img/maven_import.png)

6. Una vez que Maven haya finalizado con las importaciones. Seleccionar `Add Configuration`

![Seleccionar "Add Configuration"](./docs/img/add_config.png)

7. Seleccionar el botón `+` ubicado arriba a la izquierda y seleccionar la opción `Application`

![Seleccionar configuración de aplicación](./docs/img/select_application_config.png)

8. Renombrar a "App" y rellenar el campo `Main class` con `edu.fiuba.algo3.App` para indicar el punto de entrada de la aplicación. Luego darle a `Ok`

![Configurar aplicación](./docs/img/config_application_config.png)

9. Si desean pueden añadir la configuración de JUnit para correr todas las pruebas. Para ello ir de vuelta al botón `+` y seleccionar `JUnit`

![Seleccionar configuración de JUnit](./docs/img/select_junit_config.png)

10. Renombrar a "Test" y Cambiar `Test kind` a `All in package` y rellenar el campo `Package` con `edu.fiuba.algo3`. Seleccionar `In whole project`. Finalizar dando `Ok`

![Configurar JUnit](./docs/img/config_junit_config.png)

11. Seleccionar la configuración `Test` y darle Play (con el botón o con el shortcut correspondiente)

![Ejecutar JUnit](./docs/img/run_junit.png)

12. Luego seleccionar la configuración `App` y darle Play. Debería aparecer una ventana con el texto "Hello, JavaFX 11.0.2, running on Java 11.0.5"

![Aplicación ejecutándose](./docs/img/app_running.png)
