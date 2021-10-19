package com.motorbikes.service;

import com.motorbikes.model.Category;
import com.motorbikes.model.Client;
import com.motorbikes.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author 71GM30
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll() {
        return clientRepository.getAll();
    }
     public Optional<Client> getClient(int clientId) {
        return clientRepository.getClient(clientId);
    }
    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> unCliente = clientRepository.getClient(client.getIdClient());

            if (unCliente.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> evento= clientRepository.getClient(client.getIdClient());
            if(!evento.isEmpty()){
                if(client.getName()!=null){
                    evento.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    evento.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    evento.get().setPassword(client.getPassword());
                }
                clientRepository.save(evento.get());
                return evento.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    public boolean delete(int clientId) {
        Boolean aBoolean = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
