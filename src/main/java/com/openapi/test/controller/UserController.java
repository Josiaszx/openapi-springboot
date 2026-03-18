package com.openapi.test.controller;

import com.openapi.test.model.User;
import com.openapi.test.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Enfoque Code First - primero se escribe el código y luego se genera la documentación según lo implementado.
* Las descripciones que queramos dar en la documentación, son agregadas directamente en el código.
*/

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users", description = "Manipulate users")
/*
* Con @Tag() podemos cambiar el nombre y la descripcion de la seccion mostrada en swagger ui
*/
public class UserController {

    final private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
     * Con @Operation() podemos dar mas detalles a openApi sobre los endpoints configurados. Entre algunas opciones, podemos
     * configurar: summary, description.
     */

    @GetMapping
    @Operation(
            summary = "Get all users",
            description = "Get all user from de database"
    )
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /*
     * Con @Parameter podemos documentar parametros como un @PathVariable. Opciones: description, example, entre otros.
     */

    @GetMapping("/{id}")
    @Operation(
            summary = "Get user by id",
            description = "Get the user with the given id"
    )
    public User findById(
            @Parameter(description = "user id", example = "1")
            @PathVariable Long id
    ) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    @PostMapping
    @Operation(summary = "Save a new user")
    public void save(@RequestBody User user) {
        userRepository.save(user);
    }
}
