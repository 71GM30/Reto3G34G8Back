package com.motorbikes.repositorycrud;

import com.motorbikes.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

}
