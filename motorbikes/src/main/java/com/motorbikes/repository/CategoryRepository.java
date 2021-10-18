package com.motorbikes.repository;
import com.motorbikes.model.Category;
import com.motorbikes.repositorycrud.CategoryCrudRepository;
import com.motorbikes.repositorycrud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Categoria
 * @author dario
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    
  
    public Category save(Category category){
        return categoryCrudRepository.save(category);
    }
}