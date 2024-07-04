package com.portfolio.hris.salary.history;

import lombok.Data;

@Data
public class SalaryHistoryDTO {
    public String ueid;
    public int seq;
    public int baseSalary;
    public int performanceBonus;
    public int specialBonus;
    public String salaryComment;
    public String insertAt;
    public String insertBy;
    public String updateAt;
    public String updateBy;
}
