package com.example.backendspring.Repository;

import com.example.backendspring.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
