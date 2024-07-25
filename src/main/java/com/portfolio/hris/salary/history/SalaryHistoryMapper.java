package com.portfolio.hris.salary.history;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalaryHistoryMapper {
    List<SalaryHistoryDAO> getList();

    List<SalaryHistoryDAO> getListByUeid(String ueid);

    void createSalaryHistory(SalaryHistoryDAO salaryHistoryDAO);

    SalaryHistoryDAO getSalaryHistoryByUeidAndSeq(String ueid, int seq);

    void updateSalaryHistoryInformation(SalaryHistoryDAO salaryHistoryDAO);
}
