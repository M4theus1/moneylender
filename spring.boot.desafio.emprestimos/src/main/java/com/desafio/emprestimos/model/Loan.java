package com.desafio.emprestimos.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Loan {
    private LoanType type;
    private double interestRate;

    public Loan(LoanType type, double interestRate){
        this.type = type;
        this.interestRate = interestRate;
    }
}
