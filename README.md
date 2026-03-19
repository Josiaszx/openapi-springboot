# OpenAPI en Spring Boot

Este repositorio presenta una breve explicación e implementación sobre OpenAPI en un proyecto de Spring Boot.

## Documentación de endpoints
Para poder documentar endpoints con OpenApi y poder visualizarlos con SwaggerUI, podemos hacerlo de dos formas: Code First y Design First

### Code First
Con code first primero se escribe el codigo y luego se genera la documentacion automaticamente. Para ello implementamos algunas anotaciones para que al compilar el proyecto generaran la documentación.

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
  title: Mi API limpia
  version: 1.0.0
  description: Documentación separada del código

paths:
  /users:
    get:
      summary: Obtener usuarios
      description: Retorna todos los usuarios
      responses:
        '200':
          description: OK
```

## SwaggerUI
Para poder visualizar la documentacion generada, una vez ejecutado el proyecto, podemos acceder a algunos de los siguiente endpoints generados por OpenApi:
- `http://localhost:8080/swagger-ui/index.html` Para ver la interfaz completa.
- `http://localhost:8080/v3/api-docs` Para ver la especificacion OpenAPI en JSON.

## Dependencias
Dependencias necesarias:
- **Maven:**
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>3.0.2</version>
</dependency>
```
- **Gradle:**
```groovy
implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:3.0.2'
```