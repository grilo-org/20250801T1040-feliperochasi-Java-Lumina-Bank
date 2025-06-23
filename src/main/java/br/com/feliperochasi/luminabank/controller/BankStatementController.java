package br.com.feliperochasi.luminabank.controller;

import br.com.feliperochasi.luminabank.dto.BankMovementDTO;
import br.com.feliperochasi.luminabank.service.BankStatementService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank-statement")
public class BankStatementController {

    @Autowired
    private BankStatementService bankStatementService;

    @PostMapping()
    @Transactional
    public ResponseEntity applyNewBankingMovement(@RequestBody @Valid BankMovementDTO dto) {
        this.bankStatementService.applyNewBankingMovement(dto);
        return ResponseEntity.ok().build();
    }
}
