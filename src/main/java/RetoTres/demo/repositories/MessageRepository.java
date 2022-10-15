/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoTres.demo.repositories;

import RetoTres.demo.entities.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sebas
 */
@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    public List <Message> getAll(){
        return (List<Message>) messageCrudRepository.findAll();
    }
    
    public Optional <Message> getMessage (int id){
        return messageCrudRepository.findById(id);
    }
    
    public Message save(Message message){
        return messageCrudRepository.save(message);
    }
    
    public void delete(Message message){
        this.messageCrudRepository.delete(message);
    }
    
}
