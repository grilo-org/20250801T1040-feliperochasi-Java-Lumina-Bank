package br.com.feliperochasi.luminabank.service;

import br.com.feliperochasi.luminabank.dto.*;
import br.com.feliperochasi.luminabank.model.Address;
import br.com.feliperochasi.luminabank.model.Client;
import br.com.feliperochasi.luminabank.repository.AddressRepository;
import br.com.feliperochasi.luminabank.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final static Long ACTIVE_USER = 1L;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;

    public List<DetailsClientDTO> findAllClients() {
        List<Client> listOfClientsActive = clientRepository.findAllByActiveEquals(ACTIVE_USER);
        return listOfClientsActive.stream().map(DetailsClientDTO::new).toList();
    }

    public DetailsClientDTO findClientById(Long clientId) {
        Client clientForReturn = clientRepository.getReferenceById(clientId);
        return new DetailsClientDTO(clientForReturn);
    }

    public void createClient(ClientRegisterDTO dto) {
        Client newClient = new Client(dto);
        clientRepository.save(newClient);
    }

    public void createAddressForClient(AddressRegisterDTO dto) {
        Client clientForAddress = clientRepository.getReferenceById(dto.clientId());
        Address newAddress = new Address(dto, clientForAddress);
        addressRepository.save(newAddress);
    }

    public void updateClient(ClientUpdateDTO dto) {
        Client clientForUpdate = clientRepository.getReferenceById(dto.clientId());
        clientForUpdate.updateInfoClient(dto);
    }

    public void updateAddressOfClient(AddressUpdateClient dto) {
        Address addressForUpdate = addressRepository.getReferenceById(dto.addressId());
        addressForUpdate.updateInfoAddress(dto);
    }

    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    public void inativeClient(Long id) {
        Client clientForInative = clientRepository.getReferenceById(id);
        clientForInative.inativeClient();
    }
}
