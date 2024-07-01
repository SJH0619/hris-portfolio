package com.portfolio.hris.vacation.type;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VacationTypeMapper {
    List<VacationTypeDAO> getList();

    void createVacationType(VacationTypeDAO vacationTypeDAO);

    VacationTypeDAO getVacationTypeByVacationType(String vacationType);

    void updateVacationTypeInformation(VacationTypeDAO vacationTypeDAO);
}
