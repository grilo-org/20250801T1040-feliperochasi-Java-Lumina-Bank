package br.com.feliperochasi.luminabank.controller;

import br.com.feliperochasi.luminabank.dto.AccountRegisterDTO;
import br.com.feliperochasi.luminabank.service.AccountService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    @Transactional
    public ResponseEntity createNewAccountForClient(@RequestBody @Valid AccountRegisterDTO dto) {
        this.accountService.createNewAccountForClient(dto);
        return ResponseEntity.ok().build();
    }
}
