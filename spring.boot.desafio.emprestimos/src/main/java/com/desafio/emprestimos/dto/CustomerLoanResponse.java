package com.desafio.emprestimos.dto;

import com.desafio.emprestimos.model.Loan;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerLoanResponse {
    private String customer;
    private List<Loan> loans;

    public CustomerLoanResponse(String customer, List<Loan> loans) {
        this.customer = customer;
        this.loans = loans;
    }
}
