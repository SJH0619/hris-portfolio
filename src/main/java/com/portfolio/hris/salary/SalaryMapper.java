package com.portfolio.hris.salary;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalaryMapper {
    List<SalaryDAO> getList();

    void createSalary(SalaryDAO salaryDAO);

    SalaryDAO getSalaryByUeid(String ueid);

    void updateSalaryInformation(SalaryDAO salaryDAO);
}
