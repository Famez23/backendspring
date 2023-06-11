package com.example.backendspring.service;

import com.example.backendspring.Repository.ProductRepository;
import com.example.backendspring.model.Products;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductsService {

    private ProductRepository productRepository;


    public List<Products> getAll() {
        return  productRepository.findAll();
    }

    public Products findById (Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("id not found"+id));
    }

    public Products addProducts(Products product) {
        product.setNomenclature(product.getNomenclature());
        product.setLabel(product.getLabel());
        product.setProductType(product.getProductType());
        product.setStock(product.getStock());
        product.setPrice(product.getPrice());
        product.setStore(product.getStore());
        product.setQuantityStocked(product.getQuantityStocked());
        return productRepository.save(product);
    }

    public ResponseEntity<?> DeleteProducts(Integer id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public int UpdateProducts(Integer id, Products product){
         Products updateProducts= findById(id);
        updateProducts.setId(product.getId());
        updateProducts.setLabel(product.getLabel());
        updateProducts.setProductType(product.getProductType());
        updateProducts.setStore(product.getStore());
       updateProducts.setStock(product.getStock());
        updateProducts.setPrice(product.getPrice());
        updateProducts.setQuantityStocked(product.getQuantityStocked());

        productRepository.save(updateProducts);
        return Response.SC_CREATED ;

    }
}
