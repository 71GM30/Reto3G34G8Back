package com.motorbikes.service;

import com.motorbikes.model.Message;
import com.motorbikes.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author 71GM30
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;
    
    public Optional<Message> getMessage(int messageId) {
        return messageRepository.getMessage(messageId);
    }

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Message save(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> unMensaje = messageRepository.getMessage(message.getIdMessage());
            if (unMensaje.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> evento= messageRepository.getMessage(message.getIdMessage());
            if(!evento.isEmpty()){
                if(message.getMessageText()!=null){
                    evento.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(evento.get());
                return evento.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean delete(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
