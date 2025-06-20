package br.com.feliperochasi.luminabank.service;

import br.com.feliperochasi.luminabank.dto.ClientRegisterDTO;
import br.com.feliperochasi.luminabank.model.Client;
import br.com.feliperochasi.luminabank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void createClient(ClientRegisterDTO dto) {
        Client newClient = new Client(dto);
        clientRepository.save(newClient);
    }
}
