package com.desafio.emprestimos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerRequest {
    private int age;
    private String cpf;
    private String name;
    private double income;
    private String location;
}
