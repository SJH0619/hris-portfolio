package com.portfolio.hris.salary;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/salary")
@RequiredArgsConstructor
public class SalaryController {
    private final SalaryService salaryService;

    @GetMapping("/list")
    public String getSalaryList(Model model) {
        model.addAttribute("salaryList", salaryService.getList());

        return "/salary/list";
    }

    @PostMapping("/create")
    public String createSalary(SalaryDTO salaryDTO) {
        salaryService.createSalary(salaryDTO);

        return "redirect:/salary/list";
    }

    @GetMapping("/read/{ueid}")
    public String readSalary(@PathVariable("ueid") String ueid, Model model) {
        model.addAttribute("salary", salaryService.readSalary(ueid));

        return "/salary/read";
    }

    @PostMapping("/update")
    public String updateSalaryInformation(SalaryDTO salaryDTO) {
        salaryService.updateSalaryInformation(salaryDTO);

        return "redirect:/salary/read/" + salaryDTO.getUeid();
    }
}
