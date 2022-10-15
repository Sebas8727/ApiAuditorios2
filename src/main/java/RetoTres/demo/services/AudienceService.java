/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoTres.demo.services;

import RetoTres.demo.entities.Audience;
import RetoTres.demo.repositories.AudienceRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
public class AudienceService {
    
    @Autowired
    private AudienceRepository audienceRepository;
    
    public List<Audience> getAll(){
        return audienceRepository.getAll();
    }
    
    public Optional<Audience> getAudience (int id){
        return audienceRepository.getAudience(id);
    }
    
    public Audience save(Audience audience){
        if (audience.getId()==null){
            return audienceRepository.save(audience);
        }
        else{
        Optional<Audience> e = audienceRepository.getAudience(audience.getId());
        if (e.isEmpty()){
            return audienceRepository.save(audience);
        }
        else{
            return audience;
            }
        
        }
    }
    
    public Audience update(Audience audience){
          if(audience.getId() != null){
               Optional<Audience> e = audienceRepository.getAudience(audience.getId());
              if (!e.isEmpty()){
                  if (audience.getOwner()!=null){
                      e.get().setOwner(audience.getOwner());
                  }
                  if (audience.getName()!=null){
                      e.get().setName(audience.getName());
                  }
                  if (audience.getCapacity()!=null){
                      e.get().setCapacity(audience.getCapacity());
                  }
                  if (audience.getDescription()!=null){
                      e.get().setDescription(audience.getDescription());
                  }
                  if (audience.getCategory()!=null){
                      e.get().setCategory(audience.getCategory());
                  }
                  audienceRepository.save(e.get());
                  return e.get();
              }
              else{
                  return audience;
              }
          }
          else{
              return audience;
          }
    }
    
    public boolean deleteAudience (int id){
        Boolean eliminado = getAudience(id).map(audience ->{
            audienceRepository.delete(audience);
            return true;
        }). orElse(false);
        return eliminado;
    }
}
