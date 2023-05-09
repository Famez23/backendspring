package com.example.backendspring.controller;


import com.example.backendspring.model.StockKeeper;
import com.example.backendspring.service.StockKeeperService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/storekeeper")
public class StockKeeperController {
    StockKeeperService stockKeeperService;

    @GetMapping
    public List<StockKeeper> getAllStockKeeper(){
        return stockKeeperService.getAllStockKeeper();
    }
    @GetMapping("{id}")
    public StockKeeper getStockKeeper(@PathVariable Integer id) {
        return stockKeeperService.getStockKeeper(id);
    }
    @GetMapping("{name}")
    public Optional<Object> getStockKeeperbyName(@PathVariable String name) {
        return stockKeeperService.getStockKeeperbyName(name);
    }
    @PostMapping
    public StockKeeper addStockKeeper(@RequestBody StockKeeper stockKeeper){
        return stockKeeperService.addStockKeeper(stockKeeper);
    }
    @PutMapping("{id}")
    public int updateStockKeeper(@RequestBody StockKeeper stockKeeper, @PathVariable  Integer id){
        return stockKeeperService.updateStockKeeper(stockKeeper, id);
    }
    @DeleteMapping("{id}")
    ResponseEntity<?> deleteKeeper(@PathVariable Integer id){
        return stockKeeperService.deleteKeeper(id);
    }
}
