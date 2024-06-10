package com.portfolio.hris.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/list")
    public String getList() {
        System.out.println(employeeService.getList().toString());

        return "/employee/list";
    }

    @PostMapping("/create")
    public String createEmployee(EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);

        return "redirect:/employee/list";
    }
}
