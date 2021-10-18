package com.motorbikes.repositorycrud;

import com.motorbikes.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminCrudRepository extends CrudRepository<Admin,Integer> {

}
