# OpenAPI en Spring Boot
![Java 21](https://img.shields.io/badge/Java-21-E76F00?logo=data:image/svg%2bxml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSI2NCIgaGVpZ2h0PSI2NCIgdmlld0JveD0iMCAwIDMyIDMyIj48cGF0aCBkPSJNMTEuNjIyIDI0Ljc0cy0xLjIzLjc0OC44NTUuOTYyYzIuNTEuMzIgMy44NDcuMjY3IDYuNjI1LS4yNjdhMTAuMDIgMTAuMDIgMCAwIDAgMS43NjMuODU1Yy02LjI1IDIuNjcyLTE0LjE2LS4xNi05LjI0NC0xLjU1em0tLjgtMy40NzNzLTEuMzM2IDEuMDE1Ljc0OCAxLjIzYzIuNzI1LjI2NyA0Ljg2Mi4zMiA4LjU1LS40MjdhMy4yNiAzLjI2IDAgMCAwIDEuMjgyLjgwMWMtNy41MzQgMi4yNDQtMTUuOTc2LjIxNC0xMC41OC0xLjYwM3ptMTQuNzQ3IDYuMDlzLjkwOC43NDgtMS4wMTUgMS4zMzZjLTMuNTggMS4wNy0xNS4wMTQgMS4zOS0xOC4yMiAwLTEuMTIyLS40OCAxLjAxNS0xLjE3NSAxLjctMS4yODIuNjk1LS4xNiAxLjA3LS4xNiAxLjA3LS4xNi0xLjIzLS44NTUtOC4xNzUgMS43NjMtMy41MjYgMi41MSAxMi43NyAyLjA4NCAyMy4yOTYtLjkwOCAxOS45ODMtMi40MDR6TTEyLjIgMTcuNjMzcy01LjgyNCAxLjM5LTIuMDg0IDEuODdjMS42MDMuMjE0IDQuNzU1LjE2IDcuNjk0LS4wNTMgMi40MDQtLjIxNCA0LjgxLS42NCA0LjgxLS42NHMtLjg1NS4zNzQtMS40NDMuNzQ4Yy01LjkzIDEuNTUtMTcuMzEyLjg1NS0xNC4wNTItLjc0OCAyLjc3OC0xLjMzNiA1LjA3Ni0xLjE3NSA1LjA3Ni0xLjE3NXptMTAuNDIgNS44MjRjNS45ODQtMy4xIDMuMjA2LTYuMDkgMS4yODItNS43MTctLjQ4LjEwNy0uNjk1LjIxNC0uNjk1LjIxNHMuMTYtLjMyLjUzNC0uNDI3YzMuNzk0LTEuMzM2IDYuNzg2IDQuMDA3LTEuMjMgNi4wOSAwIDAgLjA1My0uMDUzLjEwNy0uMTZ6bS05LjgzIDguNDQyYzUuNzcuMzc0IDE0LjU4Ny0uMjE0IDE0LjgtMi45NCAwIDAtLjQyNyAxLjA3LTQuNzU1IDEuODctNC45MTYuOTA4LTExLjAwNy44LTE0LjU4Ny4yMTQgMCAwIC43NDguNjQgNC41NDIuODU1eiIgZmlsbD0iIzRlNzg5NiIvPjxwYXRoIGQ9Ik0xOC45OTYuMDAxczMuMzEzIDMuMzY2LTMuMTUyIDguNDQyYy01LjE4MyA0LjExNC0xLjE3NSA2LjQ2NSAwIDkuMTM3LTMuMDQ2LTIuNzI1LTUuMjM2LTUuMTMtMy43NC03LjM3M0MxNC4yOTQgNi44OTMgMjAuMzMyIDUuMyAxOC45OTYuMDAxem0tMS43IDE1LjMzNWMxLjU1IDEuNzYzLS40MjcgMy4zNjYtLjQyNyAzLjM2NnMzLjk1NC0yLjAzIDIuMTM3LTQuNTQyYy0xLjY1Ni0yLjQwNC0yLjk0LTMuNTggNC4wMDctNy41ODcgMCAwLTEwLjk1MyAyLjcyNS01LjcxNyA4Ljc2M3oiIGZpbGw9IiNmNTgyMTkiLz48L3N2Zz4=)
![Spring Boot 4](https://img.shields.io/badge/Spring_Boot-4-6DB33F?logo=springboot)
![OpenAPI Iniciative](https://img.shields.io/badge/Open_API_Initiative-3-6BA539?logo=openapiinitiative)
![Spring Boot 4](https://img.shields.io/badge/Swagger_UI-3-6DB33F?logo=swagger)


Este repositorio presenta una breve explicación e implementación sobre OpenAPI en un proyecto de Spring Boot.

## Documentación de endpoints
Para poder documentar endpoints con OpenApi y poder visualizarlos con SwaggerUI, podemos hacerlo de dos formas: Code First y Design First

### Code First
Con code first primero se escribe el codigo y luego se genera la documentación automaticamente. Para ello implementamos algunas anotaciones para que al compilar el proyecto generaran la documentación.

#### Anotacion `@Tag()`:
```java
@Tag() // se aplica sobre la clase (controlador) para definir el nombre de la seccion.
@Tag(name = "Users", description = "Manipulate users") // agrega el nombre Users a la seccioón y una descripción
```

**Ejemplo:**

```java
@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description = "Manipulate users")
public class UserController { ... }
```

---

#### Anotacion `@Operation()`:
```java
@Operation() // se aplica sobre los handlers en los controladores para dar detalles sobre los endpoints
@Operation(
            summary = "Get all users", // resumen de la funcion del endpoint
            description = "Get all user from de database" // descripcion mas detallada
    )
```

**Ejemplo:**

```java
@GetMapping
@Operation(
        summary = "Get all users",
        description = "Get all user from de database"
)
    public List<User> findAll() { ... }
```

---

#### Anotacion `@Parameter()`:
```java
@Paramater() // dar informacion sobre los paramentros pasados como @PathVariable o @RequestParam
// se aplica dentro de los parametros de los metodos handler
@Parameter(description = "user id", example = "1") // se espera un user id y como ejemplo da el 1
```

**Ejemplo:**

```java
public User findById(
        @Parameter(description = "user id", example = "1")
        @PathVariable Long id
) { ... }
```

### Design First
Con Design First primero se diseña la API y luego se implementa el backend. Se documenta dentro de un archivo yaml donde definimos todo lo necesario segun la especificacion de OpenAPI.

Para trabajar con design first:

 en `application.properties`:
```
# definir ubicacion del yaml de configuracion
springdoc.swagger-ui.url=/openapi.yaml
```
Una vez implementada esta configuracion, se dejara de implementar la documentacion como code first.
Luego en `src/main/resources/static/` creamos el archivo `openapi.yaml` donde se debera definir la documentación.

**Ejemplo de `openapi.yaml`:**
```yaml
openapi: 3.0.0
info:
  title: Documentacion de API con OpenApi
  version: 1.0.0
  description: Implementacion basica de OpenAPI

servers:
  - url: http://localhost:8080
    description: Servidor local

tags:
  - name: Users
    description: Manipulate users

paths:
  /api/users: #/api/users es el endpoint
    get: # GET
      tags: # nombre del tag al que pertenece el endpoint
        - Users
      summary: Get all users
      description: Get all user from de database
      responses:
        '200':
          description: Lista de usuarios obtenida exitosamente
          content:
            application/json:
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/User' # referencia a entidad retornada

components:
  schemas: # entidades retornadas
    User: # nombre de entidad
      type: object
      properties:
        id:
          type: integer
          format: int64
          description: ID auto-generado del usuario
        username:
          type: string
          description: Nombre de usuario
        email:
          type: string
          format: email
          description: Correo electrónico del usuario
      example:
        id: 1
        username: "johndoe"
        email: "john@example.com"
```
Documentacion completa en yaml del proyecto: [openapi.yaml](/src/main/resources/static/openapi.yaml)


## SwaggerUI
Para poder visualizar la documentacion generada, una vez ejecutado el proyecto, podemos acceder a algunos de los siguiente endpoints generados automaticamente:
- `http://localhost:8080/swagger-ui/index.html` Para ver la interfaz completa.
- `http://localhost:8080/v3/api-docs` Para ver la especificacion OpenAPI en JSON.

## Dependencias
Dependencias necesarias:
**Maven:**
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>3.0.2</version>
</dependency>
```
**Gradle:**
```groovy
implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:3.0.2'
```