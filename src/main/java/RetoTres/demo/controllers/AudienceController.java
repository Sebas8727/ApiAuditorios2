/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoTres.demo.controllers;

import RetoTres.demo.entities.Audience;
import RetoTres.demo.services.AudienceService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebas
 */
@RestController
@RequestMapping ("/api/Audience")
public class AudienceController {
    
    @Autowired
    private AudienceService audienceService;
    
    @GetMapping("/all")
    public List<Audience> getAudience(){
        return audienceService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Audience> getAudience(@PathVariable("id") int AudienceId){
        return audienceService.getAudience(AudienceId);
    }
    
    @PostMapping("/save")
    @ResponseStatus (HttpStatus.CREATED)
    public Audience save(@RequestBody Audience audience){
        return audienceService.save(audience);
    }
    
    @PutMapping("/update")
    @ResponseStatus (HttpStatus.CREATED)
    public Audience update(@RequestBody Audience audience){
        return audienceService.update(audience);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id") int AudienceId){
        return audienceService.deleteAudience(AudienceId);
    }
}
