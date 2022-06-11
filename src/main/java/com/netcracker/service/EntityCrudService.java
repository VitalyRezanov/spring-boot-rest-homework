package com.netcracker.service;

import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.response.DeleteResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntityCrudService<T> {

    public List<T> getAllEntities(JpaRepository<T,Integer> repository) {
        return repository.findAll();
    }

    public ResponseEntity<T> getEntityById(Integer id,JpaRepository<T,Integer> repository) throws ResourceNotFoundException {
        T entity = repository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Entity not found with id: " + id));
        return  ResponseEntity.ok(entity);
    }

    public ResponseEntity<T> addEntity(T entity, JpaRepository<T,Integer> repository) {
        //return repository.save(entity);
        return ResponseEntity.ok(repository.save(entity));
    }

    public ResponseEntity<DeleteResponse> deleteEntity(Integer id, JpaRepository<T,Integer> repository) throws ResourceNotFoundException {
        T entity = repository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Entity not found with id: " + id));
        repository.delete(entity);
        return ResponseEntity.ok(new DeleteResponse("Entity with id: " + id + " deleted"));
    }

    public ResponseEntity<T> patchEntity(Integer id, JpaRepository<T,Integer> repository, T newEntity) throws ResourceNotFoundException {
        repository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Entity not found with id: " + id));
        //return repository.save(newEntity);
        return ResponseEntity.ok(repository.save(newEntity));
    }

    public List<T> patchAllEntities(List<T> entities, JpaRepository<T,Integer> repository ) {
        repository.deleteAll();
        return repository.saveAll(entities);
    }
}
