/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoTres.demo.controllers;

import RetoTres.demo.entities.Reservation;
import RetoTres.demo.services.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sebas
 */
@RestController
@RequestMapping ("/api/Reservation")
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservation> getReservation(){
        return reservationService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Reservation> getReservetion(@PathVariable("id") int ReservationId){
        return reservationService.getReservation(ReservationId);
    }
    
    @PostMapping("/save")
    @ResponseStatus (HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
    
    @PostMapping("/update")
    @ResponseStatus (HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id") int ReservationId){
        return reservationService.deleteReservation(ReservationId);
    }
}
