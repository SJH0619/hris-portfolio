package com.portfolio.hris.salary.type;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalaryTypeMapper {
    List<SalaryTypeDAO> getList();

    void createSalaryType(SalaryTypeDAO salaryTypeDAO);

    SalaryTypeDAO getSalaryTypeBySalaryType(String salaryType);

    void updateSalaryTypeInformation(SalaryTypeDAO salaryTypeDAO);
}
