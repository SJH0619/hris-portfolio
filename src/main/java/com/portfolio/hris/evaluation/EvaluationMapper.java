package com.portfolio.hris.evaluation;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EvaluationMapper {
    List<EvaluationDAO> getList();

    void createEvaluation(EvaluationDAO evaluationDAO);

    EvaluationDAO getEvaluationByUeidAndSeq(String ueid, int seq);

    void updateEvaluationInformation(EvaluationDAO evaluationDAO);
}
