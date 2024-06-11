package com.portfolio.hris.department;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

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
}
