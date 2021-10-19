/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.motorbikes.repository;

import com.motorbikes.model.Motorbike;
import com.motorbikes.repositorycrud.MotorbikesCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author 71GM30
 */
@Repository
public class MotorbikesRepository {
    @Autowired
    private MotorbikesCrudRepository motorbikesCrudRepository;
    
    public List<Motorbike> getAll(){
        return (List<Motorbike>) motorbikesCrudRepository.findAll();
    }
    
     public Optional<Motorbike> getMotorbike(int id){
        return motorbikesCrudRepository.findById(id);
    }
    
    public Motorbike save(Motorbike motorbike){
        return motorbikesCrudRepository.save(motorbike);
    }
    public void delete(Motorbike motorbike){
        motorbikesCrudRepository.delete(motorbike);
    }
}
