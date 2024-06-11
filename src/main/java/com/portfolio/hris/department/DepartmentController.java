package com.portfolio.hris.department;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/list")
    public String getDepartmentList(Model model) {
        model.addAttribute("departmentList", departmentService.getList());

        return "/department/list";
    }

    @PostMapping("/create")
    public String createDepartment(DepartmentDTO departmentDTO) {
        departmentService.createDepartment(departmentDTO);

        return "redirect:/department/list";
    }

    @GetMapping("/read/{departmentCode}")
    public String readDepartment(@PathVariable String departmentCode, Model model) {
        model.addAttribute("department", departmentService.readDepartment(departmentCode));

        return "/department/read";
    }

    @PostMapping("/update")
    public String updateDepartmentInformation(DepartmentDTO departmentDTO) {
        departmentService.updateDepartmentInformation(departmentDTO);

        return "redirect:/department/read/" + departmentDTO.getDepartmentCode();
    }
}
