package com.portfolio.hris.evaluation;

import lombok.Data;

@Data
public class EvaluationDTO {
    public String ueid;
    public int seq;
    public String evaluationStartDate;
    public String evaluationEndDate;
    public String evaluationItem;
    public String evaluationResult;
    public String evaluationComment;
    public String evaluationResponsibility;
    public String insertAt;
    public String insertBy;
    public String updateAt;
    public String updateBy;
}
