package com.portfolio.hris.employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getList();

    void createEmployee(EmployeeDTO employeeDTO);
}
