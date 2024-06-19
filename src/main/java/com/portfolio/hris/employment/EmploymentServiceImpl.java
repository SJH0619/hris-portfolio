package com.portfolio.hris.employment;

import com.portfolio.hris.util.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmploymentServiceImpl implements EmploymentService {
    private final EmploymentMapper employmentMapper;
    private final TimeUtil timeUtil;

    @Override
    @Transactional(readOnly = true)
    public List<EmploymentDTO> getList() {
        List<EmploymentDAO> resource = employmentMapper.getList();
        List<EmploymentDTO> result = new ArrayList<>();

        resource.forEach(employment -> result.add(employment.getEmploymentDTO()));

        return result;
    }

    @Override
    @Transactional
    public void createEmployment(EmploymentDTO employmentDTO) {
        employmentDTO.setInsertAt(timeUtil.nowDateTimeString());
        employmentDTO.setInsertBy("시스템"); // TODO 나중에 수정

        EmploymentDAO employmentDAO = EmploymentDAO.applyEmploymentDTO(employmentDTO);

        employmentMapper.createEmployment(employmentDAO);
    }

    @Override
    @Transactional(readOnly = true)
    public EmploymentDTO readEmployment(String employmentType) {
        EmploymentDAO employmentDAO = employmentMapper.getEmploymentByEmploymentType(employmentType);

        return employmentDAO.getEmploymentDTO();
    }

    @Override
    @Transactional
    public void updateEmploymentInformation(EmploymentDTO employmentDTO) {
        EmploymentDAO employmentDAO = EmploymentDAO.applyEmploymentDTO(employmentDTO);

        employmentMapper.updateEmploymentInformation(employmentDAO);
    }
}
