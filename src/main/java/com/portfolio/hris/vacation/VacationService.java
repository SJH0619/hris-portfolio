package com.portfolio.hris.vacation;

import java.util.List;

public interface VacationService {
    List<VacationDTO> getList();

    void createVacation(VacationDTO vacationDTO);

    VacationDTO readVacation(String ueid, int seq);

    void updateVacationInformation(VacationDTO vacationDTO);
}
