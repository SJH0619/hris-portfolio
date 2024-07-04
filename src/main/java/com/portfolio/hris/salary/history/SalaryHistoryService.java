package com.portfolio.hris.salary.history;

import java.util.List;

public interface SalaryHistoryService {
    List<SalaryHistoryDTO> getList();

    void createSalaryHistory(SalaryHistoryDTO salaryHistoryDTO);

    SalaryHistoryDTO readSalaryHistory(String ueid, int seq);

    void updateSalaryHistoryInformation(SalaryHistoryDTO salaryHistoryDTO);
}