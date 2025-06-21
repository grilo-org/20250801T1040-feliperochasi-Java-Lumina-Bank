package br.com.feliperochasi.luminabank.controller;

import br.com.feliperochasi.luminabank.dto.AddressRegisterDTO;
import br.com.feliperochasi.luminabank.dto.AddressUpdateClient;
import br.com.feliperochasi.luminabank.dto.ClientRegisterDTO;
import br.com.feliperochasi.luminabank.dto.ClientUpdateDTO;
import br.com.feliperochasi.luminabank.service.ClientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public void listClient() {
        System.out.println("Request");
    }

    @PostMapping
    @Transactional
    public ResponseEntity createClient(@RequestBody @Valid ClientRegisterDTO dto) {
        this.clientService.createClient(dto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/address")
    @Transactional
    public ResponseEntity createAddressForClient(@RequestBody @Valid AddressRegisterDTO dto) {
        this.clientService.createAddressForClient(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateClient(@RequestBody @Valid ClientUpdateDTO dto) {
        this.clientService.updateClient(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/address")
    @Transactional
    public ResponseEntity updateAddressOfClient(@RequestBody @Valid AddressUpdateClient dto) {
        this.clientService.updateAddressOfClient(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/address/{id}")
    @Transactional
    public ResponseEntity deleteAddressOfClient(@PathVariable Long id){
        this.clientService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
