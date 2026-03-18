package com.openapi.test.controller;

import com.openapi.test.model.Product;
import com.openapi.test.model.User;
import com.openapi.test.repository.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Enfoque Code First - primero se escribe el código y luego se genera la documentación según lo implementado.
*/

@RestController
@RequestMapping("/api/products")
@Tag(name = "Products", description = "Manipulate products")
/*
 * Con @Tag() podemos cambiar el nombre y la descripcion de la seccion mostrada en swagger ui
 */
public class ProductController {

    final private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /*
    * Con @Operation() podemos dar mas detalles a openApi sobre los endpoints configurados. Entre algunas opciones, podemos
    * configurar: summary, description
    */

    @GetMapping
    @Operation(
            summary = "Get all products",
            description = "Return a list of all the products in the database"
    )
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    /*
    * Con @Parameter podemos documentar parametros como un @PathVariable. Opciones: description, example, entre otros.
    */

    @GetMapping("/{id}")
    @Operation(
            summary = "Get product by id",
            description = "Return the user with the given id"
    )
    public Product findById(
            @Parameter(description = "user   id", example = "1")
            @PathVariable Long id
    ) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with id " + id + " not found"));
    }

    @PostMapping
    @Operation(summary = "Save a new product")
    public void save(@RequestBody Product product) {
        productRepository.save(product);
    }

}
