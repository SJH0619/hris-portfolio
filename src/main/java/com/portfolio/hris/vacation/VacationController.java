package com.portfolio.hris.vacation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vacation")
@RequiredArgsConstructor
public class VacationController {
    private final VacationService vacationService;

    @GetMapping("/list")
    public String getVacationList(Model model) {
        model.addAttribute("vacationList", vacationService.getList());

        return "/vacation/list";
    }

    @PostMapping("/create")
    public String createVacation(VacationDTO vacationDTO) {
        vacationService.createVacation(vacationDTO);

        return "redirect:/vacation/list";
    }

    @GetMapping("/read/{ueid}/{seq}")
    public String readVacation(@PathVariable("ueid") String ueid, @PathVariable("seq") Integer seq, Model model) {
        model.addAttribute("vacation", vacationService.readVacation(ueid, seq));

        return "/vacation/read";
    }

    @PostMapping("/update")
    public String updateVacationInformation(VacationDTO vacationDTO) {
        vacationService.updateVacationInformation(vacationDTO);

        return "redirect:/vacation/read/" + vacationDTO.getUeid() + "/" + vacationDTO.getSeq();
    }
}
