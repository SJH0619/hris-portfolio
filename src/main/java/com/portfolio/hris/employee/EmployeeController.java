package com.portfolio.hris.employee;

import com.portfolio.hris.attendance.AttendanceService;
import com.portfolio.hris.department.DepartmentService;
import com.portfolio.hris.employment.EmploymentService;
import com.portfolio.hris.evaluation.EvaluationService;
import com.portfolio.hris.position.PositionService;
import com.portfolio.hris.salary.SalaryService;
import com.portfolio.hris.salary.history.SalaryHistoryService;
import com.portfolio.hris.vacation.VacationService;
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
    private final SalaryService salaryService;
    private final SalaryHistoryService salaryHistoryService;
    private final EvaluationService evaluationService;
    private final VacationService vacationService;
    private final AttendanceService attendanceService;

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
        EmployeeDTO employeeDTO = employeeService.readEmployee(employeeId);

        model.addAttribute("employee", employeeDTO);
        model.addAttribute("salary", salaryService.readSalary(employeeDTO.getUeid()));
        model.addAttribute("salaryHistoryList", salaryHistoryService.getListByUeid(employeeDTO.getUeid()));
        model.addAttribute("evaluationList", evaluationService.getListByUeid(employeeDTO.getUeid()));
        model.addAttribute("vacationList", vacationService.getListByUeid(employeeDTO.getUeid()));
        model.addAttribute("attendanceList", attendanceService.getListByUeid(employeeDTO.getUeid()));

        return "/employee/read";
    }

    @PostMapping("/update")
    public String updateEmployeeInformation(EmployeeDTO employeeDTO) {
        employeeService.updateEmployeeInformation(employeeDTO);

        return "redirect:/employee/read/" + employeeDTO.getEmployeeId();
    }
}
