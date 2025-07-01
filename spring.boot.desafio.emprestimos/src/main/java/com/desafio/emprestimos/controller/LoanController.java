package com.desafio.emprestimos.controller;

import com.desafio.emprestimos.dto.CustomerLoanResponse;
import com.desafio.emprestimos.dto.CustomerRequest;
import com.desafio.emprestimos.service.LoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService service) {
        this.loanService = service;
    }

    @PostMapping
    public ResponseEntity<CustomerLoanResponse> getAvailableLoans(@RequestBody CustomerRequest request){
        return ResponseEntity.ok(loanService.calculateLoans(request));
    }
}

