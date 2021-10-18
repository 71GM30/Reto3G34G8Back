package com.motorbikes.repositorycrud;

import com.motorbikes.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer>{
    
}
