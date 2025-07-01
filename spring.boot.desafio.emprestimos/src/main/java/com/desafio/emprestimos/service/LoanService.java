package com.desafio.emprestimos.service;

import com.desafio.emprestimos.dto.CustomerLoanResponse;
import com.desafio.emprestimos.dto.CustomerRequest;
import com.desafio.emprestimos.model.Loan;
import com.desafio.emprestimos.model.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanResponse calculateLoans(CustomerRequest request){
        List<Loan> loans = new ArrayList<>();

        boolean isSP = "SP".equalsIgnoreCase(request.getLocation());
        boolean isYoung = request.getAge() < 30;
        double income = request.getIncome();

        if (income <=3000){
            loans.add(new Loan(LoanType.PERSONAL, 4));
            loans.add(new Loan(LoanType.GUARANTEED, 3));
        }

        if (income >= 5000){
            loans.add(new Loan(LoanType.CONSIGNMENT, 2));
        }

        if (income > 3000 && income <= 5000 && isYoung && isSP){
            loans.add(new Loan(LoanType.PERSONAL, 4));
            loans.add(new Loan(LoanType.GUARANTEED, 3));
        }

        return new CustomerLoanResponse(request.getName(), loans);

    }
}
