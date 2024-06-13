package com.portfolio.hris.evaluation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/evaluation")
@RequiredArgsConstructor
public class EvaluationController {
    private final EvaluationService evaluationService;

    @GetMapping("/list")
    public String getEvaluationList(Model model) {
        model.addAttribute("evaluationList", evaluationService.getList());

        return "/evaluation/list";
    }

    @PostMapping("/create")
    public String createEvaluation(EvaluationDTO evaluationDTO) {
        evaluationService.createEvaluation(evaluationDTO);

        return "redirect:/evaluation/list";
    }

    @GetMapping("/read/{ueid}/{seq}")
    public String readEvaluation(@PathVariable("ueid") String ueid, @PathVariable("seq") Integer seq, Model model) {
        model.addAttribute("evaluation", evaluationService.readEvaluation(ueid, seq));

        return "/evaluation/read";
    }

    @PostMapping("/update")
    public String updateEvaluationInformation(EvaluationDTO evaluationDTO) {
        evaluationService.updateEvaluationInformation(evaluationDTO);

        return "redirect:/evaluation/read/" + evaluationDTO.getUeid() + "/" + evaluationDTO.getSeq();
    }
}
