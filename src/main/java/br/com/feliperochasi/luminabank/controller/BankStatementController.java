package br.com.feliperochasi.luminabank.controller;

import br.com.feliperochasi.luminabank.dto.BankMovementDTO;
import br.com.feliperochasi.luminabank.dto.DetailsBankStatementDTO;
import br.com.feliperochasi.luminabank.service.BankStatementService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank-statement")
public class BankStatementController {

    @Autowired
    private BankStatementService bankStatementService;

    @GetMapping("/{numberAccount}")
    public ResponseEntity<List<DetailsBankStatementDTO>> listBankStatementByAccountNumber(@PathVariable Long numberAccount) {
        return ResponseEntity.ok(this.bankStatementService.listBankStatementByAccountNumber(numberAccount));
    }

    @PostMapping()
    @Transactional
    public ResponseEntity applyNewBankingMovement(@RequestBody @Valid BankMovementDTO dto) {
        this.bankStatementService.applyNewBankingMovement(dto);
        return ResponseEntity.ok().build();
    }
}
