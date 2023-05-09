package com.example.backendspring.controller;

import com.example.backendspring.model.AccessType;
import com.example.backendspring.service.AccessTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("api/access")
public class AccessTypeController {
    AccessTypeService accessTypeService;

    @GetMapping
    public List<AccessType> getAllAccess(){
       return accessTypeService.getAllAccess();
    }

    @GetMapping("{id}")
    public AccessType getAccessById(@PathVariable Integer id){
       return accessTypeService.getAccessTypeById(id);
    }

    @PostMapping
    public AccessType addAccess(@RequestBody AccessType access){
        return accessTypeService.postAccessType(access);
    }

    @PutMapping("{id}")
    public int updateAccess(@RequestBody AccessType access, @PathVariable Integer id){
        return accessTypeService.update(access,id);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAccess(@PathVariable Integer id){
       return accessTypeService.DeleteAccessType(id);
    }

}
