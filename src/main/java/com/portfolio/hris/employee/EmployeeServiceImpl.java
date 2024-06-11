package com.portfolio.hris.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDTO> getList() {
        List<EmployeeDAO> resource = employeeMapper.getList();
        List<EmployeeDTO> result = new ArrayList<>();

        resource.forEach(employee -> result.add(employee.getEmployeeDTO()));

        return result;
    }

    @Override
    @Transactional
    public void createEmployee(EmployeeDTO employeeDTO) {
        EmployeeDAO employeeDAO = EmployeeDAO.applyEmployeeDTO(employeeDTO);

        employeeMapper.createEmployee(employeeDAO);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDTO readEmployee(String employeeId) {
        EmployeeDAO employeeDAO = employeeMapper.getEmployeeByEmployeeId(employeeId);

        return employeeDAO.getEmployeeDTO();
    }

    @Override
    @Transactional
    public void updateEmployeeInformation(EmployeeDTO employeeDTO) {
        EmployeeDAO employeeDAO = EmployeeDAO.applyEmployeeDTO(employeeDTO);

        employeeMapper.updateEmployeeInformation(employeeDAO);
    }
}
