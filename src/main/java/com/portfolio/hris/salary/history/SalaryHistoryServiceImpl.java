package com.portfolio.hris.salary.history;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryHistoryServiceImpl implements SalaryHistoryService {
    private final SalaryHistoryMapper salaryHistoryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<SalaryHistoryDTO> getList() {
        List<SalaryHistoryDAO> resource = salaryHistoryMapper.getList();
        List<SalaryHistoryDTO> result = new ArrayList<>();

        resource.forEach(salaryHistory -> result.add(salaryHistory.getSalaryHistoryDTO()));

        return result;
    }

    @Override
    public List<SalaryHistoryDTO> readSalaryHistoryByUeid(String ueid) {
        List<SalaryHistoryDAO> resource = salaryHistoryMapper.readSalaryHistoryByUeid(ueid);
        List<SalaryHistoryDTO> result = new ArrayList<>();

        resource.forEach(salaryHistory -> result.add(salaryHistory.getSalaryHistoryDTO()));

        return result;
    }

    @Override
    @Transactional
    public void createSalaryHistory(SalaryHistoryDTO salaryHistoryDTO) {
        SalaryHistoryDAO salaryHistoryDAO = SalaryHistoryDAO.applySalaryHistoryDTO(salaryHistoryDTO);

        salaryHistoryMapper.createSalaryHistory(salaryHistoryDAO);
    }

    @Override
    @Transactional(readOnly = true)
    public SalaryHistoryDTO readSalaryHistory(String ueid, int seq) {
        SalaryHistoryDAO salaryHistoryDAO = salaryHistoryMapper.getSalaryHistoryByUeidAndSeq(ueid, seq);

        if (salaryHistoryDAO == null) {
            return null;
        }

        return salaryHistoryDAO.getSalaryHistoryDTO();
    }

    @Override
    @Transactional
    public void updateSalaryHistoryInformation(SalaryHistoryDTO salaryHistoryDTO) {
        SalaryHistoryDAO salaryHistoryDAO = SalaryHistoryDAO.applySalaryHistoryDTO(salaryHistoryDTO);

        salaryHistoryMapper.updateSalaryHistoryInformation(salaryHistoryDAO);
    }
}
