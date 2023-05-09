package com.example.backendspring.controller;


import com.example.backendspring.model.ProductsType;
import com.example.backendspring.service.ProductsTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/type")
public class ProductTypeController {
    ProductsTypeService productsTypeService;

    @GetMapping
    List<ProductsType> getAllTypes() {
        return productsTypeService.getAllTypes();
    }
    @GetMapping("/id/{id}")
    ProductsType getById(@PathVariable Integer id) {
        return productsTypeService.getById(id);
    }
    @GetMapping("/label/{familyLabel}")
    ProductsType getProductType(@PathVariable String familyLabel) {
        return productsTypeService.getProductType(familyLabel);
    }

    @PostMapping
    ProductsType addType(@RequestBody ProductsType productType) {
        return productsTypeService.addType(productType);
    }
    @PutMapping("{id}")
    public int updateType (@RequestBody ProductsType productsType, @PathVariable Integer id){
        return productsTypeService.updateType(productsType, id);
    }
    //
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteType(@PathVariable Integer id) {
       return productsTypeService.deleteType(id);
    }
}
