package com.portfolio.hris.vacation;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VacationDAO {
    private String ueid;
    private int seq;
    private String vacationType;
    private String startDate;
    private String endDate;
    private int usingDays;
    private int remainingDays;
    private String vacationPurpose;
    private String approvalResponsibility;
    private String vacationRequestDate;
    private String vacationApprovalDate;
    private String insertAt;
    private String insertBy;
    private String updateAt;
    private String updateBy;

    public static VacationDAO applyVacationDTO(VacationDTO vacationDTO) {
        return VacationDAO.builder()
                .ueid(vacationDTO.getUeid())
                .seq(vacationDTO.getSeq())
                .vacationType(vacationDTO.getVacationType())
                .startDate(vacationDTO.getStartDate())
                .endDate(vacationDTO.getEndDate())
                .usingDays(vacationDTO.getUsingDays())
                .remainingDays(vacationDTO.getRemainingDays())
                .vacationPurpose(vacationDTO.getVacationPurpose())
                .approvalResponsibility(vacationDTO.getApprovalResponsibility())
                .vacationRequestDate(vacationDTO.getVacationRequestDate())
                .vacationApprovalDate(vacationDTO.getVacationApprovalDate())
                .insertAt(vacationDTO.getInsertAt())
                .insertBy(vacationDTO.getInsertBy())
                .updateAt(vacationDTO.getUpdateAt())
                .updateBy(vacationDTO.getUpdateBy())
                .build();
    }

    public VacationDTO getVacationDTO() {
        VacationDTO vacationDTO = new VacationDTO();
        vacationDTO.setUeid(ueid);
        vacationDTO.setSeq(seq);
        vacationDTO.setVacationType(vacationType);
        vacationDTO.setStartDate(startDate);
        vacationDTO.setEndDate(endDate);
        vacationDTO.setUsingDays(usingDays);
        vacationDTO.setRemainingDays(remainingDays);
        vacationDTO.setVacationPurpose(vacationPurpose);
        vacationDTO.setApprovalResponsibility(approvalResponsibility);
        vacationDTO.setVacationRequestDate(vacationRequestDate);
        vacationDTO.setVacationApprovalDate(vacationApprovalDate);
        vacationDTO.setInsertAt(insertAt);
        vacationDTO.setInsertBy(insertBy);
        vacationDTO.setUpdateAt(updateAt);
        vacationDTO.setUpdateBy(updateBy);

        return vacationDTO;
    }
}
