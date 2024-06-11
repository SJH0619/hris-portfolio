package com.portfolio.hris.department;

import java.util.List;

public interface DepartmentService {
    List<DepartmentDTO> getList();

    void createDepartment(DepartmentDTO departmentDTO);
}
