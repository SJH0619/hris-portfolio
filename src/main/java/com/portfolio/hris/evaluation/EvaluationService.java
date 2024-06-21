package com.portfolio.hris.evaluation;

import java.util.List;

public interface EvaluationService {
    List<EvaluationDTO> getList();

    List<EvaluationDTO> getListByUeid(String ueid);

    void createEvaluation(EvaluationDTO evaluationDTO);

    EvaluationDTO readEvaluation(String ueid, int seq);

    void updateEvaluationInformation(EvaluationDTO evaluationDTO);
}
