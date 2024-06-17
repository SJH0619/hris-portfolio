package com.portfolio.hris.position;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/position")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService positionService;

    @GetMapping("/list")
    public String getPositionList(Model model) {
        model.addAttribute("positionList", positionService.getList());

        return "/position/list";
    }

    @GetMapping("/create")
    public String createPosition() {
        return "/position/create";
    }

    @PostMapping("/create")
    public String createPosition(PositionDTO positionDTO) {
        positionService.createPosition(positionDTO);

        return "redirect:/position/list";
    }

    @GetMapping("/read/{positionCode}")
    public String readPosition(@PathVariable("positionCode") String positionCode, Model model) {
        model.addAttribute("position", positionService.readPosition(positionCode));

        return "/position/read";
    }

    @PostMapping("/update")
    public String updatePositionInformation(PositionDTO positionDTO) {
        positionService.updatePositionInformation(positionDTO);

        return "redirect:/position/read/" + positionDTO.getPositionCode();
    }
}
