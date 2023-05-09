package com.example.backendspring.controller;

import com.example.backendspring.model.Stock;
import com.example.backendspring.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/stock")
public class StockController {
    StockService stockService;

    @GetMapping
    public List<Stock>  getAll(){
      return  stockService.getStockList();
    }
    @GetMapping("{id}")
    public Stock getStockById(@PathVariable Integer id){
        return stockService.getStockById(id);
    }
    @PostMapping
    public Stock addStock(Stock stock){
        return stockService.addStock(stock);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Stock> removeStock(@PathVariable Integer id){
       return stockService.removeStock(id);
    }
    @PutMapping("{id}")
    public String updateStock(@RequestBody Stock stock,@PathVariable Integer id){
        return stockService.updateStock(stock, id);
    }
}
