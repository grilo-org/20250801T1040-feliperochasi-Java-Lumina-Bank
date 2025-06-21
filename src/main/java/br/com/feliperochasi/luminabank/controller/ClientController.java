package br.com.feliperochasi.luminabank.controller;

import br.com.feliperochasi.luminabank.dto.*;
import br.com.feliperochasi.luminabank.service.ClientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<DetailsClientDTO>> findAllClients() {
        return ResponseEntity.ok(this.clientService.findAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailsClientDTO> findClientById(@PathVariable Long id) {
        return ResponseEntity.ok(this.clientService.findClientById(id));
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

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativeClient(@PathVariable Long id){
        this.clientService.inativeClient(id);
        return ResponseEntity.noContent().build();
    }
}
