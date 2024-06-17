package com.portfolio.hris.employment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employment")
@RequiredArgsConstructor
public class EmploymentController {
    private final EmploymentService employmentService;

    @GetMapping("/list")
    public String employmentList(Model model) {
        model.addAttribute("employmentList", employmentService.getList());

        return "/employment/list";
    }

    @GetMapping("/create")
    public String createEmployment() {
        return "/employment/create";
    }

    @PostMapping("/create")
    public String createEmployment(EmploymentDTO employmentDTO) {
        employmentService.createEmployment(employmentDTO);

        return "redirect:/employment/list";
    }

    @GetMapping("/read/{employmentType}")
    public String readEmployment(@PathVariable("employmentType") String employmentType, Model model) {
        model.addAttribute("employment", employmentService.readEmployment(employmentType));

        return "/employment/read";
    }

    @PostMapping("/update")
    public String updateEmploymentInformation(EmploymentDTO employmentDTO) {
        employmentService.updateEmploymentInformation(employmentDTO);

        return "redirect:/employment/read/" + employmentDTO.getEmploymentType();
    }
}
