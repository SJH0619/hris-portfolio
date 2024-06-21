package com.portfolio.hris.vacationtype;

import java.util.List;

public interface VacationTypeService {
    List<VacationTypeDTO> getList();

    void createVacationType(VacationTypeDTO vacationTypeDTO);

    VacationTypeDTO readVacationType(String vacationType);

    void updateVacationTypeInformation(VacationTypeDTO vacationTypeDTO);
}
