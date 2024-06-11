package com.portfolio.hris.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/list")
    public String getEmployeeList(Model model) {
        model.addAttribute("employeeList", employeeService.getList());

        return "/employee/list";
    }

    @PostMapping("/create")
    public String createEmployee(EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);

        return "redirect:/employee/list";
    }

    @GetMapping("/read/{employeeId}")
    public String readEmployee(@PathVariable String employeeId, Model model) {
        model.addAttribute("employee", employeeService.readEmployee(employeeId));

        return "/employee/read";
    }

    @PostMapping("/update")
    public String updateEmployeeInformation(EmployeeDTO employeeDTO) {
        employeeService.updateEmployeeInformation(employeeDTO);

        return "redirect:/employee/read/" + employeeDTO.getEmployeeId();
    }
}
