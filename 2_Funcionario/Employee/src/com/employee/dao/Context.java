package com.employee.dao;

import com.employee.domain.Employee;
import java.util.ArrayList;
import java.util.List;

public abstract class Context {
    public static List<Employee> dbEmployees = new ArrayList<>();
}