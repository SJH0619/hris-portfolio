package com.portfolio.hris.evaluation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationServiceImpl implements EvaluationService {
    private final EvaluationMapper evaluationMapper;

    @Override
    @Transactional(readOnly = true)
    public List<EvaluationDTO> getList() {
        List<EvaluationDAO> resource = evaluationMapper.getList();
        List<EvaluationDTO> result = new ArrayList<>();

        resource.forEach(evaluation -> result.add(evaluation.getEvaluationDTO()));

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EvaluationDTO> getListByUeid(String ueid) {
        List<EvaluationDAO> resource = evaluationMapper.getListByUeid(ueid);
        List<EvaluationDTO> result = new ArrayList<>();

        resource.forEach(evaluation -> result.add(evaluation.getEvaluationDTO()));

        return result;
    }

    @Override
    @Transactional
    public void createEvaluation(EvaluationDTO evaluationDTO) {
        EvaluationDAO evaluationDAO = EvaluationDAO.applyEvaluationDTO(evaluationDTO);

        evaluationMapper.createEvaluation(evaluationDAO);
    }

    @Override
    @Transactional(readOnly = true)
    public EvaluationDTO readEvaluation(String ueid, int seq) {
        EvaluationDAO evaluationDAO = evaluationMapper.getEvaluationByUeidAndSeq(ueid, seq);

        return evaluationDAO.getEvaluationDTO();
    }

    @Override
    @Transactional
    public void updateEvaluationInformation(EvaluationDTO evaluationDTO) {
        EvaluationDAO evaluationDAO = EvaluationDAO.applyEvaluationDTO(evaluationDTO);

        evaluationMapper.updateEvaluationInformation(evaluationDAO);
    }
}
