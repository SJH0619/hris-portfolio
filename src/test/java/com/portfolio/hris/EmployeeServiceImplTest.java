package com.portfolio.hris;

import com.portfolio.hris.employee.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceImplTest {
    @Autowired
    EmployeeServiceImpl employeeService;

    @Test
    public void testMakeUeid() {
        for (int i = 0; i < 10; i++) {
            System.out.println(employeeService.makeUeid());
        }
    }
}
