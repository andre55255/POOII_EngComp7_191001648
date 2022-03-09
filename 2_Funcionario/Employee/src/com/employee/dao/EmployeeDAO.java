package com.employee.dao;

import com.employee.domain.Employee;
import java.util.List;

public class EmployeeDAO {
    public static int idEmployee;
    
    public boolean Insert(Employee emp) {
        if (Context.dbEmployees.isEmpty())
            EmployeeDAO.idEmployee = 1;
        
        emp.setId(idEmployee);
        EmployeeDAO.idEmployee++;
        
        return Context.dbEmployees.add(emp);
    }
    
    public boolean Delete(int id) {
        Employee empSave = FindById(id);
        if (empSave == null)
            return false;
        
        return Context.dbEmployees.remove(empSave);
    }
    
    public Employee FindById(int id) {
        Employee emp = null;
        
        for (Employee e : Context.dbEmployees) {
            if (e.getId() == id)
                emp = e;
        }
        
        return emp;
    }
    
    public List<Employee> FindAll() {
        return Context.dbEmployees;
    }
}