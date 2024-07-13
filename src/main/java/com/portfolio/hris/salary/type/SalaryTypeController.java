package com.portfolio.hris.salary.type;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/salaryType")
@RequiredArgsConstructor
public class SalaryTypeController {
    private final SalaryTypeService salaryTypeService;

    @GetMapping("/list")
    public String getSalaryTypeList(Model model) {
        model.addAttribute("salaryTypeList", salaryTypeService.getList());

        return "/salaryType/list";
    }

    @GetMapping("/create")
    public String createSalaryType() {
        return "/salaryType/create";
    }

    @PostMapping("/create")
    public String createSalaryType(SalaryTypeDTO salaryTypeDTO) {
        salaryTypeService.createSalaryType(salaryTypeDTO);

        return "redirect:/salaryType/list";
    }

    @GetMapping("/read/{salaryType}")
    public String readSalaryType(@PathVariable("salaryType") String salaryType, Model model) {
        model.addAttribute("salaryType", salaryTypeService.readSalaryType(salaryType));

        return "/salaryType/read";
    }

    @PostMapping("/update")
    public String updateSalaryTypeInformation(SalaryTypeDTO salaryTypeDTO) {
        salaryTypeService.updateSalaryTypeInformation(salaryTypeDTO);

        return "redirect:/salaryType/read/" + salaryTypeDTO.getSalaryType();
    }
}
