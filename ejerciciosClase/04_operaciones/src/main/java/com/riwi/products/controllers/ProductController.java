package com.riwi.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.riwi.products.entities.Product;
import com.riwi.products.services.service_abstract.IProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {
    @Autowired
    private final IProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(this.productService.getAll());
    }

    @GetMapping(path ="{id}")
    public ResponseEntity<Product>get(@PathVariable Long id){
        return ResponseEntity.ok(this.productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> insert (@RequestBody Product objProduct){
        return ResponseEntity.ok(this.productService.save(objProduct));

    }

    @PutMapping(path ="/{id}")
    public ResponseEntity<Product> update(
            @PathVariable Long id, //viene por URL
            @RequestBody Product product){ //viene por el cuerpo de la petición

            return ResponseEntity.ok(this.productService.update(id,product));
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        this.productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
