package com.portfolio.hris.salary.type;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryTypeServiceImpl implements SalaryTypeService {
    private final SalaryTypeMapper salaryTypeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<SalaryTypeDTO> getList() {
        List<SalaryTypeDAO> resource = salaryTypeMapper.getList();
        List<SalaryTypeDTO> result = new ArrayList<>();

        resource.forEach(salaryType -> result.add(salaryType.getSalaryTypeDTO()));

        return result;
    }

    @Override
    @Transactional
    public void createSalaryType(SalaryTypeDTO salaryTypeDTO) {
        SalaryTypeDAO salaryTypeDAO = SalaryTypeDAO.applySalaryTypeDTO(salaryTypeDTO);

        salaryTypeMapper.createSalaryType(salaryTypeDAO);
    }

    @Override
    @Transactional(readOnly = true)
    public SalaryTypeDTO readSalaryType(String salaryType) {
        SalaryTypeDAO salaryTypeDAO = salaryTypeMapper.getSalaryTypeBySalaryType(salaryType);

        if (salaryTypeDAO == null) {
            return null;
        }

        return salaryTypeDAO.getSalaryTypeDTO();
    }

    @Override
    @Transactional
    public void updateSalaryTypeInformation(SalaryTypeDTO salaryTypeDTO) {
        SalaryTypeDAO salaryTypeDAO = SalaryTypeDAO.applySalaryTypeDTO(salaryTypeDTO);

        salaryTypeMapper.updateSalaryTypeInformation(salaryTypeDAO);
    }
}
