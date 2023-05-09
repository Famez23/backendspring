package com.example.backendspring.controller;

import com.example.backendspring.model.Store;
import com.example.backendspring.service.StoreService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/store")
public class StoreController {
    StoreService storeService;
    @GetMapping
    public List<Store> getStoreList() {
       return storeService.getStoreList();
    }
    @GetMapping("{id}")
    public Store getStore(@PathVariable Integer id) {
        return storeService.getStoreById(id);
    }
    @PostMapping
    public Store addStore(@RequestBody Store store){
        return storeService.addStore(store);
    }
    @PutMapping("{id}")
    public String updateStore(@RequestBody Store store,@PathVariable Integer id){
        return storeService.updateStore(store,id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStore(@PathVariable Integer id){
        return storeService.deleteStore(id);
    }
}
