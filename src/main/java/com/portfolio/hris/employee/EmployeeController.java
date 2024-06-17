package com.portfolio.hris.employee;

import com.portfolio.hris.department.DepartmentService;
import com.portfolio.hris.employment.EmploymentService;
import com.portfolio.hris.position.PositionService;
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
    private final DepartmentService departmentService;
    private final PositionService positionService;
    private final EmploymentService employmentService;

    @GetMapping("/list")
    public String getEmployeeList(Model model) {
        model.addAttribute("employeeList", employeeService.getList());

        return "/employee/list";
    }

    @GetMapping("/create")
    public String createEmployee(Model model) {
        model.addAttribute("departmentList", departmentService.getList());
        model.addAttribute("positionList", positionService.getList());
        model.addAttribute("employmentList", employmentService.getList());

        return "/employee/create";
    }

    @PostMapping("/create")
    public String createEmployee(EmployeeDTO employeeDTO) {
        employeeService.createEmployee(employeeDTO);

        return "redirect:/employee/list";
    }

    @GetMapping("/read/{employeeId}")
    public String readEmployee(@PathVariable("employeeId") String employeeId, Model model) {
        model.addAttribute("employee", employeeService.readEmployee(employeeId));

        return "/employee/read";
    }

    @PostMapping("/update")
    public String updateEmployeeInformation(EmployeeDTO employeeDTO) {
        employeeService.updateEmployeeInformation(employeeDTO);

        return "redirect:/employee/read/" + employeeDTO.getEmployeeId();
    }
}
