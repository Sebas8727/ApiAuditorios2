/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoTres.demo.services;

import RetoTres.demo.entities.Reservation;
import RetoTres.demo.repositories.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation (int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation reservation){
        if (reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        }
        else{
        Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
        if (e.isEmpty()){
            return reservationRepository.save(reservation);
        }
        else{
            return reservation;
            }
        
        }
    }
    
    public Reservation update(Reservation reservation){
          if(reservation.getIdReservation()!= null){
               Optional<Reservation> e = reservationRepository.getReservation(reservation.getIdReservation());
              if (!e.isEmpty()){
                  
                  if (reservation.getStartDate()!=null){
                      e.get().setStartDate(reservation.getStartDate());
                  }
                  if (reservation.getDevolutionDate()!=null){
                      e.get().setDevolutionDate(reservation.getDevolutionDate());
                  }
                  
                  return e.get();
              }
              else{
                  return reservation;
              }
          }
          else{
              return reservation;
          }
    }
    
    public boolean deleteReservation (int id){
        Boolean eliminado = getReservation(id).map(reservation ->{
            reservationRepository.delete(reservation);
            return true;
        }). orElse(false);
        return eliminado;
    }
}
