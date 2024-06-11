package com.portfolio.hris.department;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;

    @Override
    public List<DepartmentDTO> getList() {
        List<DepartmentDAO> resource = departmentMapper.getList();
        List<DepartmentDTO> result = new ArrayList<>();

        resource.forEach(department -> result.add(department.getDepartmentDTO()));

        return result;
    }

    @Override
    public void createDepartment(DepartmentDTO departmentDTO) {
        DepartmentDAO departmentDAO = DepartmentDAO.applyDepartmentDTO(departmentDTO);

        departmentMapper.createDepartment(departmentDAO);
    }

    @Override
    public DepartmentDTO readDepartment(String departmentCode) {
        DepartmentDAO departmentDAO = departmentMapper.getDepartmentByDepartmentCode(departmentCode);

        return departmentDAO.getDepartmentDTO();
    }

    @Override
    public void updateDepartmentInformation(DepartmentDTO departmentDTO) {
        DepartmentDAO departmentDAO = DepartmentDAO.applyDepartmentDTO(departmentDTO);

        departmentMapper.updateDepartmentInformation(departmentDAO);
    }
}
