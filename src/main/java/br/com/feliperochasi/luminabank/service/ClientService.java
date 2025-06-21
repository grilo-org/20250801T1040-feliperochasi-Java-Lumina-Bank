package br.com.feliperochasi.luminabank.service;

import br.com.feliperochasi.luminabank.dto.AddressRegisterDTO;
import br.com.feliperochasi.luminabank.dto.AddressUpdateClient;
import br.com.feliperochasi.luminabank.dto.ClientRegisterDTO;
import br.com.feliperochasi.luminabank.dto.ClientUpdateDTO;
import br.com.feliperochasi.luminabank.model.Address;
import br.com.feliperochasi.luminabank.model.Client;
import br.com.feliperochasi.luminabank.repository.AddressRepository;
import br.com.feliperochasi.luminabank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    public void createClient(ClientRegisterDTO dto) {
        Client newClient = new Client(dto);
        clientRepository.save(newClient);
    }

    public void createAddressForClient(AddressRegisterDTO dto) {
        Client clientForAddress = getClient(dto.clientId());
        Address newAddress = new Address(dto, clientForAddress);
        addressRepository.save(newAddress);
    }

    public void updateClient(ClientUpdateDTO dto) {
        Client clientForUpdate = getClient(dto.clientId());
        clientForUpdate.updateInfoClient(dto);
    }

    public void updateAddressOfClient(AddressUpdateClient dto) {
        Address addressForUpdate = addressRepository.getReferenceById(dto.addressId());
        addressForUpdate.updateInfoAddress(dto);
    }

    private Client getClient(Long clientId) {
        return clientRepository.getReferenceById(clientId);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
