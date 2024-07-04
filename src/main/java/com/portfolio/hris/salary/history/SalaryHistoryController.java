package com.portfolio.hris.salary.history;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/salaryHistory")
@RequiredArgsConstructor
public class SalaryHistoryController {
    private final SalaryHistoryService salaryHistoryService;

    @GetMapping("/list")
    public String getSalaryHistoryList(Model model) {
        model.addAttribute("salaryHistoryList", salaryHistoryService.getList());

        return "/salaryHistory/list";
    }

    @PostMapping("/create")
    public String createSalaryHistory(SalaryHistoryDTO salaryHistoryDTO) {
        salaryHistoryService.createSalaryHistory(salaryHistoryDTO);

        return "redirect:/salaryHistory/list";
    }

    @GetMapping("/read/{ueid}/{seq}")
    public String readSalaryHistory(@PathVariable("ueid") String ueid, @PathVariable("seq") Integer seq, Model model) {
        model.addAttribute("salaryHistory", salaryHistoryService.readSalaryHistory(ueid, seq));

        return "/salaryHistory/read";
    }

    @PostMapping("/update")
    public String updateSalaryHistoryInformation(SalaryHistoryDTO salaryHistoryDTO) {
        salaryHistoryService.updateSalaryHistoryInformation(salaryHistoryDTO);

        return "redirect:/salaryHistory/read/" + salaryHistoryDTO.getUeid() + "/" + salaryHistoryDTO.getSeq();
    }
}
