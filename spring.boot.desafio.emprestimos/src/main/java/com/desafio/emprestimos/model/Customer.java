package com.desafio.emprestimos.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private String name;
    private int age;
    private String cpf;
    private double income;
    private String location;
}
