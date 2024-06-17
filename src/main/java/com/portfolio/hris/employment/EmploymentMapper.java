package com.portfolio.hris.employment;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmploymentMapper {
    List<EmploymentDAO> getList();

    void createEmployment(EmploymentDAO employmentDAO);

    EmploymentDAO getEmploymentByEmploymentType(String EmploymentType);

    void updateEmploymentInformation(EmploymentDAO employmentDAO);
}
