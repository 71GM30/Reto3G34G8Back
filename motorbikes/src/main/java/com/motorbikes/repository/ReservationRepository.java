package com.motorbikes.repository;
import com.motorbikes.model.Reservation;
import com.motorbikes.repositorycrud.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Reservacion
 * @author dario
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }  
  
    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
}