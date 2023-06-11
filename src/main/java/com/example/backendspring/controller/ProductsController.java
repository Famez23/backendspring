package com.example.backendspring.controller;

import com.example.backendspring.model.Products;
import com.example.backendspring.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("api/product")
public class ProductsController {

    private ProductsService productService;

    @GetMapping
    List<Products> all() {
       return  productService.getAll();
    }
    @GetMapping("{id}")
    Products findById (@PathVariable Integer id) {
        return productService.findById(id);
    }
    @PostMapping
    Products addProducts(@RequestBody Products product) {
      return productService.addProducts(product);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> DeleteProducts(@PathVariable Integer id) {
        return productService.DeleteProducts(id);
    }
    @PutMapping("{id}")
    public int UpdateProducts(@PathVariable Integer id, @RequestBody Products product){
        return productService.UpdateProducts(id, product);
    }
}
