/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoTres.demo.repositories;

import RetoTres.demo.entities.Audience;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sebas
 */
@Repository
public class AudienceRepository {
    
    @Autowired
    private AudienceCrudRepository audienceCrudRepository;
    
    public List <Audience> getAll(){
        return (List<Audience>) audienceCrudRepository.findAll();
    }
    
    public Optional <Audience> getAudience (int id){
        return audienceCrudRepository.findById(id);
    }
    
    public Audience save(Audience admin){
        return audienceCrudRepository.save(admin);
    }
    
    public void delete(Audience audience){
        audienceCrudRepository.delete(audience);
    }
    
}
