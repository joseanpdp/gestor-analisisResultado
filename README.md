# Manual de uso

Esto es un proyecto desarrollado para que los docentes puedan registrar los resultados de sus alumnos y comprobar el número de aprobados que hay en cada asignatura y cada grupo.

## Índice

- [ADMINISTRADOR](#administrador)
  - [Secciones de la aplicación](#secciones-de-la-aplicación)
  - [Formulario de grupo](#formulario-de-grupo)
  - [Análisis de informe](#análisis-de-informe)
  - [Cambio de contraseña](#cambio-de-contraseña)
- [USUARIO](#usuario)

## ADMINISTRADOR

### Secciones de la aplicación

Al acceder a la aplicación, lo primero que aparece es la pantalla de inicio de sesión. En ella, se puede introducir las siguientes credenciales de administrador:

**Usuario**

```text
angalo
```

**Contraseña**

```text
123
```

Tras iniciar sesión, se mostrará la pantalla principal, que es un menú de selección donde podremos elegir la asignatura y el grupo del que queramos registrar sus resultados:

![Menú principal](/mediaReadme/seleccionAsignaturas.png)

#### Formulario de grupo

Al hacer click en alguno de los grupos mostrados y clasificados por asignatura y curso, verás un formulario de los resultados de ese grupo seleccionado.

Un ejemplo sería el de ESO2-B de **Lengua Castellana - ESO 2**:

![Formulario vacío](/mediaReadme/formularioVacio.png)

En este formulario, encontrarás las siguientes secciones:

- Temas didácticos de la programación
- Resultados obtenidos
- Dificultades que ha encontrado
- Propuestas de mejora

En la esquina superior izquierda hay un botón por si se quiere cancelar la resolución del formulario. En caso de que no sea así, una vez se rellenan todos los campos, puedes darle al botón de guardar, que añadirá los resultados del formulario a la base de datos y te devolverá a la página anterior.

Cabe aclarar que el número de alumnos del grupo y los alumnos aprobados son campos obligatorios, el resto son opcionales.

![Menú principal, análisis guardado](/mediaReadme/seleccionAsignaturasAnalisisGuardado.png)

Ahora el círculo a la izquierda del grupo cuyos resultados han sido guardados aparecerá de color verde para indicar su resolución.

Si se quieren revisar los datos guardados, tan solo hay que entrar de nuevo en el formulario del grupo, mostrando todo lo que se haya marcado o escrito.

![Formulario escrito](/mediaReadme/formularioRelleno.png)

Para cambiar algo, tan solo hay que seleccionar y modificar el campo que se quiera actualizar y luego guardarlo de nuevo.

#### Análisis de informe

Para ver un análisis general de los alumnos aprobados tan solo hay que darle click al botón **Análisis de informes** de la esquina superior derecha. Así accederemos a una sección donde se mostrarán las gráficas de alumnos aprobados contra alumnos suspensos por gana grupo, según la asignatura de cada curso.

![Análisis de informes con solo 3 grupos registrados](/mediaReadme/analisisDeInformes.png)

En este caso, como solo se han guardado los 3 formularios que se veían en la anterior sección, solo se muestran sus datos en esta gráfica.

En el caso de de tener más resultados, se irían añadiendo a esta pantalla. O bien añadiendo un par de barras más a una gráfica si es de la misma asginatura o creando una nueva si es de una diferente.

Así se vería el menú de selección:

![Menú principal, todo resuelto](/mediaReadme/seleccionAsignaturasCompleto.png)

Y así la pantalla de los análisis:

![Analisis de informes completo](/mediaReadme/analisisDeInformesCompleto.png)

Para poder navegar fácilmente de una asignatura a otra se puede navegar mediante el menú lateral, además de también poder regresar a la sección anterior.

#### Cambio de contraseña

![Formulario para cambiar contraseña](/mediaReadme/formularioCambiarPassword.png)

En esta pantalla se puede cambiar la contraseña del usuario que ha iniciado sesión.

## USUARIO

Realmente en esta versión de la aplicación no hay una diferencia notable entre las acciones del administrador y el usuario, pero aquí hay un usuario de muestra por si se quiere ver otro perfil:

**Usuario**
```text
lumasa
```

**Contraseña**
```text
123
```
















EJECUTAR TODOS ESTOS COMANDOS DENTRO DE LA CARPETA RAÍZ DEL PROYECTO: p27_docente

export MYSQLPASSWORD=hola

docker rm -f gestor-formularios

docker run -d \
--name gestor-formularios \
-e MYSQL_ROOT_PASSWORD=${MYSQLPASSWORD} \
-e MYSQL_DATABASE=formularios \
-p 3307:3306 \
-v ./mysql-data:/var/lib/mysql \
mysql:8.0

mvn spring-boot:run

docker logs -f gestor-formularios

docker exec -it gestor-formularios mysql -u root -p

# RUTAS
```curl localhost:8083/api/asignaturas```
```curl localhost:8083/api/asignaturas/{id}```
```curl -X POST localhost:8083/api/asignaturas -H "Content-Type: application/json" -d '{"nombre":"Asignatura 1","abreviatura":"as1","nivel":"1","grupo":"1"}'```

```curl localhost:8083/api/grupos```
```curl localhost:8083/api/grupos/{id}```
```curl -X POST localhost:8083/api/grupos -H "Content-Type: application/json" -d '{"nombre":"Grupo 1"}'```
