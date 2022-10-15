/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RetoTres.demo.services;

import RetoTres.demo.entities.Message;
import RetoTres.demo.repositories.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage (int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message message){
        if (message.getIdMessage()==null){
            return messageRepository.save(message);
        }
        else{
        Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
        if (e.isEmpty()){
            return messageRepository.save(message);
        }
        else{
            return message;
            }
        
        }
    }
    
    public Message update(Message message){
          if(message.getIdMessage()!= null){
               Optional<Message> e = messageRepository.getMessage(message.getIdMessage());
              if (!e.isEmpty()){
                  if (message.getMessageText()!=null){
                      e.get().setMessageText(message.getMessageText());
                  }
                  if (message.getClient()!=null){
                      e.get().setClient(message.getClient());
                  }
                  if (message.getAudience()!=null){
                      e.get().setAudience(message.getAudience());
                  }
                  
                  return e.get();
              }
              else{
                  return message;
              }
          }
          else{
              return message;
          }
    }
    
    public boolean deleteMessage (int id){
        Boolean eliminado = getMessage(id).map(message ->{
            messageRepository.delete(message);
            return true;
        }). orElse(false);
        return eliminado;
    }
}
