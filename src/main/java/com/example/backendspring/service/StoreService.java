package com.example.backendspring.service;

import com.example.backendspring.Repository.StoreRepository;
import com.example.backendspring.model.Store;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StoreService {
    StoreRepository storeRepository;

    public List<Store> getStoreList() {
        return storeRepository.findAll();
    }
    public Store getStoreById(Integer id){
        return storeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Store not found with id " + id));
    }
    public Store addStore (Store store){
        store.setName(store.getName());
        store.setAddress(store.getAddress());
        return storeRepository.save(store);
    }
    public String updateStore(Store store, Integer id) {
        Store updatedStore = getStoreById(id);
        updatedStore.setName(store.getName());
        updatedStore.setAddress(store.getAddress());
        storeRepository.save(updatedStore);
        return  "update done successfully";
    }
    public ResponseEntity<?> deleteStore(Integer id){
        storeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
