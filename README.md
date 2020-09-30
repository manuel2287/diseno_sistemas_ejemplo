# Ejemplo Ejercicio 
## Requerimientos
- JDK 1.8 or later
- Gradle 4+ or Maven 3.2+
- IDE:
    - IntelliJ
    - Netbeans
    - Eclipse
## Instalación
Dentro del proyecto, en el directorio raíz escribir el siguiente comando

```bash
./gradlew bootRun
```

Esto iniciará las descarga de las dependencias y correra la aplicacion, sirviendola en el puerto 8080.
Para ver la aplicación corriendo, abra un navegador e introduzca el siguiente link: http://localhost:8080/?user=1

El proyecto usa Hibernate como ORM y h2 como base de datos. Para poder acceder a la base de datos ingrese a: http://localhost:8080/h2-console y de click en connect sin ingresar ninguna contraseña.

Para agregar nuevos datos a la base de datos, como ser alumno, docente, materia o cursada, se lo puede hacer agregando las sentencias sql en el archivo: src/main/resources/data.sql

Las vistas que cargan los controlodares se encuentran en la carpeta:
src/main/resources/templates

Documentación: 
Spring: https://spring.io/guides/gs/serving-web-content/
Hibernate: https://hibernate.org/orm/documentation/5.4/
