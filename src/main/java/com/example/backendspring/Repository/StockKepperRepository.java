package com.example.backendspring.Repository;

import com.example.backendspring.model.StockKeeper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockKepperRepository extends JpaRepository<StockKeeper, Integer> {

    Optional<Object> findByName(String name);
}
