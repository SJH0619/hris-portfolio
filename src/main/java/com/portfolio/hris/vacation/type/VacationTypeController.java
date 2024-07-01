package com.portfolio.hris.vacation.type;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vacationType")
@RequiredArgsConstructor
public class VacationTypeController {
    private final VacationTypeService vacationTypeService;

    @GetMapping("/list")
    public String getVacationTypeList(Model model) {
        model.addAttribute("vacationTypeList", vacationTypeService.getList());

        return "/vacationType/list";
    }

    @GetMapping("/create")
    public String createVacationType() {
        return "/vacationType/create";
    }

    @PostMapping("/create")
    public String createVacationType(VacationTypeDTO vacationTypeDTO) {
        vacationTypeService.createVacationType(vacationTypeDTO);

        return "redirect:/vacationType/list";
    }

    @GetMapping("/read/{vacationType}")
    public String readVacationType(@PathVariable("vacationType") String vacationType, Model model) {
        model.addAttribute("vacationType", vacationTypeService.readVacationType(vacationType));

        return "/vacationType/read";
    }

    @PostMapping("/update")
    public String updateVacationType(VacationTypeDTO vacationTypeDTO) {
        vacationTypeService.updateVacationTypeInformation(vacationTypeDTO);

        return "redirect:/vacationType/read/" + vacationTypeDTO.getVacationType();
    }
}
