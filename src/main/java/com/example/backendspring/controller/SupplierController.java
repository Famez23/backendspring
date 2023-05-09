package com.example.backendspring.controller;

import com.example.backendspring.model.Supplier;
import com.example.backendspring.service.SupplierService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/supplier")
public class SupplierController {
    SupplierService supplierService;

    @GetMapping
    public List<Supplier> getSuppliers(){
       return supplierService.getAll();
    }
    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Integer id){
        return supplierService.getById(id);
    }
    @PostMapping
    public Supplier addSupplier(@RequestBody Supplier supplier){
        return supplierService.addSupplier(supplier);
    }
    @PutMapping("/{id}")
    public String updateSupplier(@RequestBody Supplier supplier,@PathVariable Integer id){
        return supplierService.updateSupplier(supplier,id);
    }
    @DeleteMapping("/{id}")
    public String deleteSupplier(@PathVariable Integer id) {
      return  supplierService.deleteSupplier(id);
    }
}
