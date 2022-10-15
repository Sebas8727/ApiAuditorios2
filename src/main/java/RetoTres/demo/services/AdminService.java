/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoTres.demo.services;

import RetoTres.demo.entities.Admin;
import RetoTres.demo.repositories.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
public class AdminService {
    
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    public Optional<Admin> getAdmin (int id){
        return adminRepository.getAdmin(id);
    }
    
    public Admin save(Admin admin){
        if (admin.getId()==null){
            return adminRepository.save(admin);
        }
        else{
        Optional<Admin> e = adminRepository.getAdmin(admin.getId());
        if (e.isEmpty()){
            return adminRepository.save(admin);
        }
        else{
            return admin;
            }
        
        }
    }
    
    public Admin update(Admin admin){
          if(admin.getId() != null){
               Optional<Admin> e = adminRepository.getAdmin(admin.getId());
              if (!e.isEmpty()){
                  if (admin.getName()!=null){
                      e.get().setName(admin.getName());
                  }
                  if (admin.getEmail()!=null){
                      e.get().setEmail(admin.getEmail());
                  }
                  if (admin.getPassword()!=null){
                      e.get().setPassword(admin.getPassword());
                  }
                  
                  return e.get();
              }
              else{
                  return admin;
              }
          }
          else{
              return admin;
          }
    }
    
    public boolean deleteAdmin (int id){
        Boolean eliminado = getAdmin(id).map(admin ->{
            adminRepository.delete(admin);
            return true;
        }). orElse(false);
        return eliminado;
    }
}
