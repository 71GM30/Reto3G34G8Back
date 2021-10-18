package com.motorbikes.service;

import com.motorbikes.model.Message;
import com.motorbikes.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Mensaje
 * @author dario
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

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
}
