package com.example.backendspring.Repository;

import com.example.backendspring.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StoreRepository extends JpaRepository<Store, Integer> {

}
