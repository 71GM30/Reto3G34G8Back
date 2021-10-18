package com.motorbikes.service;

import com.motorbikes.model.Admin;
import com.motorbikes.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Admin
 * @author dario
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
 
    public List<Admin> getAll(){
       return adminRepository.getAll();
    }
    
    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> admin1 = adminRepository.getAdmin(admin.getIdAdmin());
            if (admin1.isEmpty()) {
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }
}
