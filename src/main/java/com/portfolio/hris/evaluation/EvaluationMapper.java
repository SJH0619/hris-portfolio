package com.portfolio.hris.evaluation;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EvaluationMapper {
    List<EvaluationDAO> getList();

    List<EvaluationDAO> getListByUeid(String ueid);

    void createEvaluation(EvaluationDAO evaluationDAO);

    EvaluationDAO getEvaluationByUeidAndSeq(String ueid, int seq);

    void updateEvaluationInformation(EvaluationDAO evaluationDAO);
}
