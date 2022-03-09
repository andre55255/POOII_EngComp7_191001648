package com.employee.domain;

import java.time.LocalDate;

public abstract class Employee {
    private int id;
    private String cpf;
    private String name;
    private LocalDate birthDate;
    private String department;
    private double baseSalary;
    
    public Employee() { }

    public Employee(String cpf, String name, LocalDate birthDate, String department, double baseSalary) {
        this.cpf = cpf;
        this.name = name;
        this.birthDate = birthDate;
        this.department = department;
        this.baseSalary = baseSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    public abstract double getBonus();
}