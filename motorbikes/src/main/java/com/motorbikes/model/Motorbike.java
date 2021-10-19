/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.motorbikes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *Entidad motorbike 
 * @author 71GM30
 */
@Entity
@Table(name="motorbike")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Motorbike implements Serializable{
    /**
     * columna id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * columna name
     */
    @Column (nullable=false,length=45)
    private String name;
    @Column (nullable=false,length=45)
    /**
     * columna marca
     */
    private String brand;
    /**
     * columna año
     */
    private Integer year;
    /**
     * columna descripcion
     */
    @Column(nullable=false,length=250)
    private String description;
    
    /**
     * relacion tabla categoria
     */
    @ManyToOne
    @JoinColumn (name="category")
    @JsonIgnoreProperties("motorbikes")
    private Category category;
    /**
     * relacion tabla mensajes
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="motorbike")
    @JsonIgnoreProperties({"motorbike","client"})
    private List<Message> messages;
    
    /**
     * relacion tabla reservations
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="motorbike")
    @JsonIgnoreProperties({"motorbike","messages"})
    private List<Message> reservations;
    
}
