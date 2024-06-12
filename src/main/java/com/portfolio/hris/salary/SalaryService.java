package com.portfolio.hris.salary;

import java.util.List;

public interface SalaryService {
    List<SalaryDTO> getList();

    void createSalary(SalaryDTO salaryDTO);

    SalaryDTO readSalary(String ueid);

    void updateSalaryInformation(SalaryDTO salaryDTO);
}
