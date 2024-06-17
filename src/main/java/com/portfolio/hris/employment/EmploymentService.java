package com.portfolio.hris.employment;

import java.util.List;

public interface EmploymentService {
    List<EmploymentDTO> getList();

    void createEmployment(EmploymentDTO employmentDTO);

    EmploymentDTO readEmployment(String employmentType);

    void updateEmploymentInformation(EmploymentDTO employmentDTO);
}
