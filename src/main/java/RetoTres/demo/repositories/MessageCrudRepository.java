/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package RetoTres.demo.repositories;

import RetoTres.demo.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sebas
 */
public interface MessageCrudRepository extends JpaRepository<Message, Integer> {
    
}
