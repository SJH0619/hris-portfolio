package com.portfolio.hris.salary.type;

import java.util.List;

public interface SalaryTypeService {
    List<SalaryTypeDTO> getList();

    void createSalaryType(SalaryTypeDTO salaryTypeDTO);

    SalaryTypeDTO readSalaryType(String salaryType);

    void updateSalaryTypeInformation(SalaryTypeDTO salaryTypeDTO);
}
