/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.motorbikes.service;

import com.motorbikes.model.Motorbike;
import com.motorbikes.repository.MotorbikesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @author 71GM30
 */
@Service
public class MotorbikeService {
    @Autowired
    private MotorbikesRepository motorbikesRepository;
    
    public List<Motorbike> getAll(){
        return motorbikesRepository.getAll();
    }
    
    public Optional<Motorbike> getMotorbike(int motorbikeId) {
        return motorbikesRepository.getMotorbike(motorbikeId);
    }
    
    public Motorbike save(Motorbike motorbike){
        if(motorbike.getId()==null){
            return motorbikesRepository.save(motorbike);
        }else{
            Optional<Motorbike> evtMotorbike = motorbikesRepository.getMotorbike(motorbike.getId());

                if (evtMotorbike.isEmpty()) {
                    return motorbikesRepository.save(motorbike);
                } else {
                    return motorbike;
                }
        }
    }
    
    public Motorbike update(Motorbike motorbike){
        if(motorbike.getId()!=null){
            Optional<Motorbike> evento=motorbikesRepository.getMotorbike(motorbike.getId());
            if(!evento.isEmpty()){
                if(motorbike.getName()!=null){
                    evento.get().setName(motorbike.getName());
                }
                if(motorbike.getBrand()!=null){
                    evento.get().setBrand(motorbike.getBrand());
                }
                if(motorbike.getYear()!=null){
                    evento.get().setYear(motorbike.getYear());
                }
                if(motorbike.getDescription()!=null){
                    evento.get().setDescription(motorbike.getDescription());
                }
                if(motorbike.getCategory()!=null){
                    evento.get().setCategory(motorbike.getCategory());
                }
                motorbikesRepository.save(evento.get());
                return evento.get();
            }else{
                return motorbike;
            }
        }else{
            return motorbike;
        }
    }


    public boolean delete(int motorbikeId) {
        Boolean aBoolean = getMotorbike(motorbikeId).map(bike -> {
            motorbikesRepository.delete(bike);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
