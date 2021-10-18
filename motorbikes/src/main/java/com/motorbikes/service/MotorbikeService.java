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
}
