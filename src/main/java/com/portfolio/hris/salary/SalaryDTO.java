package com.portfolio.hris.salary;

import lombok.Data;

@Data
public class SalaryDTO {
    public String ueid;
    public String salaryType;
    public String paymentDate;
    public String baseSalary;
    public String performanceBonus;
    public String specialBonus;
    public String insertAt;
    public String insertBy;
    public String updateAt;
    public String updateBy;
}
