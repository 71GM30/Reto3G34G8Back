package com.motorbikes.service;

import com.motorbikes.model.Category;
import com.motorbikes.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author 71GM30
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }
     public Optional<Category> getCategory(int CategoriaId) {
        return categoryRepository.getCategory(CategoriaId);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> category1 = categoryRepository.getCategory(category.getId());
            if (category1.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }
    
     public Category update(Category categoria){
        if(categoria.getId()!=null){
            Optional<Category>evento=categoryRepository.getCategory(categoria.getId());
            if(!evento.isEmpty()){
                if(categoria.getDescription()!=null){
                    evento.get().setDescription(categoria.getDescription());
                }
                if(categoria.getName()!=null){
                    evento.get().setName(categoria.getName());
                }
                return categoryRepository.save(evento.get());
            }
        }
        return categoria;
    }
     
    public boolean delete(int categoriaId){
        Boolean d=getCategory(categoriaId).map(categoria -> {
            categoryRepository.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
    
}
