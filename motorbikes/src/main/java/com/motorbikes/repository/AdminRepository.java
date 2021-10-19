package com.motorbikes.repository;
import com.motorbikes.model.Admin;
import com.motorbikes.repositorycrud.AdminCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 
 * @author 71GM30
 */
@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    
    public List<Admin> getAll(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }   
  
    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);
    }
    
    public void delete(Admin admin){
         adminCrudRepository.deleteById(admin.getIdAdmin());
    }
}