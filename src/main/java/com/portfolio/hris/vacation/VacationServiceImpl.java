package com.portfolio.hris.vacation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacationServiceImpl implements VacationService {
    private final VacationMapper vacationMapper;

    @Override
    @Transactional(readOnly = true)
    public List<VacationDTO> getList() {
        List<VacationDAO> resource = vacationMapper.getList();
        List<VacationDTO> result = new ArrayList<>();

        resource.forEach(vacation -> result.add(vacation.getVacationDTO()));

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<VacationDTO> getListByUeid(String ueid) {
        List<VacationDAO> resource = vacationMapper.getListByUeid(ueid);
        List<VacationDTO> result = new ArrayList<>();

        resource.forEach(vacation -> result.add(vacation.getVacationDTO()));

        return result;
    }

    @Override
    @Transactional
    public void createVacation(VacationDTO vacationDTO) {
        VacationDAO vacationDAO = VacationDAO.applyVacationDTO(vacationDTO);

        vacationMapper.createVacation(vacationDAO);
    }

    @Override
    @Transactional(readOnly = true)
    public VacationDTO readVacation(String ueid, int seq) {
        VacationDAO vacationDAO = vacationMapper.getVacationByUeidAndSeq(ueid, seq);

        return vacationDAO.getVacationDTO();
    }

    @Override
    @Transactional
    public void updateVacationInformation(VacationDTO vacationDTO) {
        VacationDAO vacationDAO = VacationDAO.applyVacationDTO(vacationDTO);

        vacationMapper.updateVacationInformation(vacationDAO);
    }
}
