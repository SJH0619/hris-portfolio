package com.portfolio.hris.evaluation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EvaluationDAO {
    private String ueid;
    private int seq;
    private String evaluationStartDate;
    private String evaluationEndDate;
    private String evaluationItem;
    private String evaluationResult;
    private String evaluationComment;
    private String evaluationResponsibility;
    private String insertAt;
    private String insertBy;
    private String updateAt;
    private String updateBy;

    public static EvaluationDAO applyEvaluationDTO(EvaluationDTO evaluationDTO) {
        return EvaluationDAO.builder()
                .ueid(evaluationDTO.getUeid())
                .seq(evaluationDTO.getSeq())
                .evaluationStartDate(evaluationDTO.getEvaluationStartDate())
                .evaluationEndDate(evaluationDTO.getEvaluationEndDate())
                .evaluationItem(evaluationDTO.getEvaluationItem())
                .evaluationResult(evaluationDTO.getEvaluationResult())
                .evaluationComment(evaluationDTO.getEvaluationComment())
                .evaluationResponsibility(evaluationDTO.getEvaluationResponsibility())
                .insertAt(evaluationDTO.getInsertAt())
                .insertBy(evaluationDTO.getInsertBy())
                .updateAt(evaluationDTO.getUpdateAt())
                .updateBy(evaluationDTO.getUpdateBy())
                .build();
    }

    public EvaluationDTO getEvaluationDTO() {
        EvaluationDTO evaluationDTO = new EvaluationDTO();
        evaluationDTO.setUeid(ueid);
        evaluationDTO.setSeq(seq);
        evaluationDTO.setEvaluationStartDate(evaluationStartDate);
        evaluationDTO.setEvaluationEndDate(evaluationEndDate);
        evaluationDTO.setEvaluationItem(evaluationItem);
        evaluationDTO.setEvaluationResult(evaluationResult);
        evaluationDTO.setEvaluationComment(evaluationComment);
        evaluationDTO.setEvaluationResponsibility(evaluationResponsibility);
        evaluationDTO.setInsertAt(insertAt);
        evaluationDTO.setInsertBy(insertBy);
        evaluationDTO.setUpdateAt(updateAt);
        evaluationDTO.setUpdateBy(updateBy);

        return evaluationDTO;
    }
}
