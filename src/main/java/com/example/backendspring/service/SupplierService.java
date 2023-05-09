package com.example.backendspring.service;

import com.example.backendspring.Repository.SupplierRepository;
import com.example.backendspring.model.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SupplierService {
    SupplierRepository supplierRepository;

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }
    public Supplier getById(Integer id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id " + id));
    }
    public Supplier addSupplier(Supplier supplier) {
        supplier.setRegistrationNumber(supplier.getRegistrationNumber());
        supplier.setName(supplier.getName());
       return supplierRepository.save(supplier);
    }
    public String updateSupplier(Supplier supplier, Integer id){
       Supplier updatedSupplier= getById(id);
       updatedSupplier.setRegistrationNumber(supplier.getRegistrationNumber());
       updatedSupplier.setName(supplier.getName());
       return "update done successfully";
    }
    public String deleteSupplier(Integer id){
         supplierRepository.deleteById(id);
         return "delete done successfully";
    }
}
