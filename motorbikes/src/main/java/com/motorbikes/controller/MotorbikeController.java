/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.motorbikes.controller;

import com.motorbikes.model.Motorbike;
import com.motorbikes.service.MotorbikeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 71GM30
 */
@RestController
@RequestMapping("/")
@CrossOrigin(origins = "/", methods= {RequestMethod.GET,RequestMethod.POST})
public class MotorbikeController {
    
    
    @Autowired
    private MotorbikeService motorbikeService;

    @GetMapping("api/Motorbike/holaMundo")
    public String saluda(){
    return "<h1>Hola Mundo!</h1>";
    }
    
    @GetMapping("api/Motorbike/all")
    public List<Motorbike> getAll(){
        return motorbikeService.getAll();
    }
    
    @PostMapping("api/Motorbike/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike save(@RequestBody Motorbike motorbike){
        
        return motorbikeService.save(motorbike);
    }
}
