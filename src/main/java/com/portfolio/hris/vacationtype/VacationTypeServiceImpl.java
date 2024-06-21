package com.portfolio.hris.vacationtype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationTypeServiceImpl implements VacationTypeService {
    private final VacationTypeMapper vacationTypeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<VacationTypeDTO> getList() {
        List<VacationTypeDAO> resource = vacationTypeMapper.getList();
        List<VacationTypeDTO> result = new ArrayList<>();

        resource.forEach(vacation -> result.add(vacation.getVacationTypeDTO()));

        return result;
    }

    @Override
    @Transactional
    public void createVacationType(VacationTypeDTO vacationTypeDTO) {
        VacationTypeDAO vacationTypeDAO = VacationTypeDAO.applyVacationTypeDTO(vacationTypeDTO);

        vacationTypeMapper.createVacationType(vacationTypeDAO);
    }

    @Override
    @Transactional(readOnly = true)
    public VacationTypeDTO readVacationType(String vacationType) {
        VacationTypeDAO vacationTypeDAO = vacationTypeMapper.getVacationTypeByVacationType(vacationType);

        return vacationTypeDAO.getVacationTypeDTO();
    }

    @Override
    @Transactional
    public void updateVacationTypeInformation(VacationTypeDTO vacationTypeDTO) {
        VacationTypeDAO vacationTypeDAO = VacationTypeDAO.applyVacationTypeDTO(vacationTypeDTO);

        vacationTypeMapper.updateVacationTypeInformation(vacationTypeDAO);
    }
}
