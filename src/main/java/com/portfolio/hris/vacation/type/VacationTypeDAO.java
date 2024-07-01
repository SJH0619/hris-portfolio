package com.portfolio.hris.vacation.type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacationTypeDAO {
    private String vacationType;
    private String vacationTypeName;
    private String vacationTypeComment;
    private String insertAt;
    private String insertBy;
    private String updateAt;
    private String updateBy;

    public static VacationTypeDAO applyVacationTypeDTO(VacationTypeDTO vacationTypeDTO) {
        return VacationTypeDAO.builder()
                .vacationType(vacationTypeDTO.getVacationType())
                .vacationTypeName(vacationTypeDTO.getVacationTypeName())
                .vacationTypeComment(vacationTypeDTO.getVacationTypeComment())
                .insertAt(vacationTypeDTO.getInsertAt())
                .insertBy(vacationTypeDTO.getInsertBy())
                .updateAt(vacationTypeDTO.getUpdateAt())
                .updateBy(vacationTypeDTO.getUpdateBy())
                .build();
    }

    public VacationTypeDTO getVacationTypeDTO() {
        VacationTypeDTO vacationTypeDTO = new VacationTypeDTO();
        vacationTypeDTO.setVacationType(vacationType);
        vacationTypeDTO.setVacationTypeName(vacationTypeName);
        vacationTypeDTO.setVacationTypeComment(vacationTypeComment);
        vacationTypeDTO.setInsertAt(insertAt);
        vacationTypeDTO.setInsertBy(insertBy);
        vacationTypeDTO.setUpdateAt(updateAt);
        vacationTypeDTO.setUpdateBy(updateBy);

        return vacationTypeDTO;
    }
}
