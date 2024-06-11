package com.portfolio.hris.department;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;

    @Override
    @Transactional(readOnly = true)
    public List<DepartmentDTO> getList() {
        List<DepartmentDAO> resource = departmentMapper.getList();
        List<DepartmentDTO> result = new ArrayList<>();

        resource.forEach(department -> result.add(department.getDepartmentDTO()));

        return result;
    }

    @Override
    @Transactional
    public void createDepartment(DepartmentDTO departmentDTO) {
        DepartmentDAO departmentDAO = DepartmentDAO.applyDepartmentDTO(departmentDTO);

        departmentMapper.createDepartment(departmentDAO);
    }

    @Override
    @Transactional(readOnly = true)
    public DepartmentDTO readDepartment(String departmentCode) {
        DepartmentDAO departmentDAO = departmentMapper.getDepartmentByDepartmentCode(departmentCode);

        return departmentDAO.getDepartmentDTO();
    }

    @Override
    @Transactional
    public void updateDepartmentInformation(DepartmentDTO departmentDTO) {
        DepartmentDAO departmentDAO = DepartmentDAO.applyDepartmentDTO(departmentDTO);

        departmentMapper.updateDepartmentInformation(departmentDAO);
    }
}
