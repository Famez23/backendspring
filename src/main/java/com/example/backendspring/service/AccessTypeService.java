package com.example.backendspring.service;

import com.example.backendspring.Repository.AccessTypeRepository;
import com.example.backendspring.model.AccessType;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AccessTypeService {
    AccessTypeRepository accessTypeRepository;

    public List<AccessType> getAllAccess(){
        return accessTypeRepository.findAll();
    }
    public AccessType getAccessTypeById(Integer id){
        return accessTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("No such access type"));
    }
    public AccessType postAccessType(AccessType accessType){
        accessType.setId(accessType.getId());
        accessType.setLabel(accessType.getLabel());
        return accessTypeRepository.save(accessType);
    }
    public int update(AccessType accessType, Integer id){
        AccessType updatedAccessType = getAccessTypeById(id);
        updatedAccessType.setId(accessType.getId());
        updatedAccessType.setLabel(accessType.getLabel());
        accessTypeRepository.save(updatedAccessType);
        return Response.SC_CREATED;
    }
    public ResponseEntity<?> DeleteAccessType(Integer id) {
        accessTypeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
