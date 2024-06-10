package com.portfolio.hris.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/list")
    public String getList() {
        System.out.println(employeeService.getList().toString());

        return "/employee/list";
    }
}
