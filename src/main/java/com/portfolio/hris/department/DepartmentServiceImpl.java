package com.portfolio.hris.department;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.hris.util.TimeUtil;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentMapper departmentMapper;
    private final TimeUtil timeUtil;

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
        departmentDTO.setFoundationDate(departmentDTO.getFoundationDate().replace("-", ""));
        departmentDTO.setInsertAt(timeUtil.nowDateTimeString());
        departmentDTO.setInsertBy("시스템"); // TODO 나중에 변경 필요

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
