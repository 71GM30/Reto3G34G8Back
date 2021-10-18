package com.motorbikes.repositorycrud;

import com.motorbikes.model.Message;
import org.springframework.data.repository.CrudRepository;


public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
    
}
