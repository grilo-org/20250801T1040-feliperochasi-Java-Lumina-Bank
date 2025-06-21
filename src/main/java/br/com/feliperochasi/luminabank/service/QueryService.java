package br.com.feliperochasi.luminabank.service;

import br.com.feliperochasi.luminabank.model.Client;
import br.com.feliperochasi.luminabank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClient(Long clientId) {
        return clientRepository.getReferenceById(clientId);
    }
}
