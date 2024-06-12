package com.portfolio.hris.salary;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {
    private final SalaryMapper salaryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<SalaryDTO> getList() {
        List<SalaryDAO> resource = salaryMapper.getList();
        List<SalaryDTO> result = new ArrayList<>();

        resource.forEach(salary -> result.add(salary.getSalaryDTO()));

        return result;
    }

    @Override
    @Transactional
    public void createSalary(SalaryDTO salaryDTO) {
        SalaryDAO salaryDAO = SalaryDAO.applySalaryDTO(salaryDTO);

        salaryMapper.createSalary(salaryDAO);
    }

    @Override
    @Transactional(readOnly = true)
    public SalaryDTO readSalary(String ueid) {
        SalaryDAO salaryDAO = salaryMapper.getSalaryByUeid(ueid);

        return salaryDAO.getSalaryDTO();
    }

    @Override
    @Transactional
    public void updateSalaryInformation(SalaryDTO salaryDTO) {
        SalaryDAO salaryDAO = SalaryDAO.applySalaryDTO(salaryDTO);

        salaryMapper.updateSalaryInformation(salaryDAO);
    }
}
