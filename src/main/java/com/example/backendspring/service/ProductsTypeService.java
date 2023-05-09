package com.example.backendspring.service;

import com.example.backendspring.Repository.ProductsTypeRepository;
import com.example.backendspring.model.ProductsType;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductsTypeService {
    ProductsTypeRepository productsTypeRepository;


    public List<ProductsType> getAllTypes() {
        return productsTypeRepository.findAll();
    }
    public ProductsType getById( Integer id) {
        return productsTypeRepository.findById(id).orElseThrow(()->new RuntimeException("Product type not found with id " + id));
    }
    public ProductsType getProductType( String familyLabel) {
        return productsTypeRepository.findByFamilyLabel(familyLabel);
    }


    public ProductsType addType( ProductsType productType) {
        return productsTypeRepository.save(productType);
    }

    public int updateType ( ProductsType productType, Integer id){
        ProductsType updatedType=getById(id);
        updatedType.setId(productType.getId());
        updatedType.setFamilyLabel(productType.getFamilyLabel());

        productsTypeRepository.save(updatedType);
        return Response.SC_OK;
    }
    public ResponseEntity<?> deleteType( Integer id){
        productsTypeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
