package com.motorbikes.repositorycrud;

import com.motorbikes.model.Motorbike;
import org.springframework.data.repository.CrudRepository;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 71GM30
 */
public interface MotorbikesCrudRepository extends CrudRepository<Motorbike,Integer> {
    
}
