package com.portfolio.hris.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeDTO> getList() {
        List<EmployeeDAO> resource = employeeMapper.getList();
        List<EmployeeDTO> result = new ArrayList<>();

        resource.forEach(employee -> result.add(employee.getEmployeeDTO()));

        return result;
    }
}
