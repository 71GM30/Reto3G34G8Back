package com.motorbikes.service;

import com.motorbikes.model.Reservation;
import com.motorbikes.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Reservacion
 * @author dario
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
 
    public List<Reservation> getAll(){
       return reservationRepository.getAll();
    }
    
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservationUno = reservationRepository.getReservation(reservation.getIdReservation());
            if (reservationUno.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }
}
