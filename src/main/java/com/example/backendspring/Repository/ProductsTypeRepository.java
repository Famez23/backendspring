package com.example.backendspring.Repository;

import com.example.backendspring.model.ProductsType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsTypeRepository extends JpaRepository<ProductsType, Integer> {

    ProductsType findByFamilyLabel(String familyLabel);
}
