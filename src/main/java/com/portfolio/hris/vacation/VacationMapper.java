package com.portfolio.hris.vacation;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VacationMapper {
    List<VacationDAO> getList();

    List<VacationDAO> getListByUeid(String ueid);

    void createVacation(VacationDAO vacationDAO);

    VacationDAO getVacationByUeidAndSeq(String ueid, int seq);

    void updateVacationInformation(VacationDAO vacationDAO);
}
