package com.portfolio.hris.employee;

import com.portfolio.hris.util.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final TimeUtil timeUtil;
    private final PasswordEncoder passwordEncoder;
    private final SecureRandom random = new SecureRandom();

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
        employeeDTO.setUeid(makeUeid());
        employeeDTO.setBirth(employeeDTO.getBirth().replace("-",""));
        employeeDTO.setJoinDate(employeeDTO.getJoinDate().replace("-",""));
        employeeDTO.setEmployeeId(employeeDTO.getJoinDate() + employeeDTO.getUeid());
        employeeDTO.setPassword(passwordEncoder.encode("0000")); // 초기 생성시 0000으로 고정
        employeeDTO.setInsertAt(timeUtil.nowDateTimeString());
        employeeDTO.setInsertBy("시스템"); // TODO 차후 현재 로그인한 사용자의 정보를 받아와야 함

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

    public String makeUeid() {
        StringBuilder sb = new StringBuilder();
        // ASCII 코드에서 0-9A-Za-z에 해당하는 배열
        int[] pattern = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, // 0 - 9
                65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, // A - Z
                97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122}; // a - z

        for(int i = 0; i < 4; i++) {
            sb.append((char) pattern[random.nextInt(pattern.length)]);
        }

        return sb.toString();
    }
}
