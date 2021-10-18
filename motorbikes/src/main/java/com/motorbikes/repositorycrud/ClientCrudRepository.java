package com.motorbikes.repositorycrud;

import com.motorbikes.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Integer>{
    
}
