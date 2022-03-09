package com.employee.domain;

import java.time.LocalDate;

public class President extends Employee {

    public President(String cpf, String name, LocalDate birthDate, String department, double baseSalary) {
        super(cpf, name, birthDate, department, baseSalary);
    }

    @Override
    public double getBonus() {
        return this.getBaseSalary() * 0.05;
    }
}