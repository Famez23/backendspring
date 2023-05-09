package com.example.backendspring.service;

import com.example.backendspring.Repository.StockKepperRepository;
import com.example.backendspring.model.StockKeeper;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StockKeeperService {
    StockKepperRepository stockKepperRepository;


    public List<StockKeeper> getAllStockKeeper(){
        return stockKepperRepository.findAll();
    }

    public StockKeeper getStockKeeper( Integer id) {
        return stockKepperRepository.findById(id)
                .orElseThrow(()->new RuntimeException("stockKeeper not found with id " + id));
    }

    public Optional<Object> getStockKeeperbyName(String name) {
        return stockKepperRepository.findByName(name);
    }

    public StockKeeper addStockKeeper(StockKeeper stockKeeper){
        return stockKepperRepository.save(stockKeeper);
    }

    public int updateStockKeeper( StockKeeper stockKeeper,  Integer id){
        StockKeeper updatedKeeper = getStockKeeper(id);
        updatedKeeper.setId(stockKeeper.getId());
        updatedKeeper.setName(stockKeeper.getName());
        updatedKeeper.setLastname(stockKeeper.getLastname());
        updatedKeeper.setAccessType(stockKeeper.getAccessType());

        stockKepperRepository.save(updatedKeeper);
        return Response.SC_ACCEPTED;
    }

    public ResponseEntity<?> deleteKeeper( Integer id){
        stockKepperRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
