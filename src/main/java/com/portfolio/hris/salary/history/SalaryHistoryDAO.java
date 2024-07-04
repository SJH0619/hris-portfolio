package com.portfolio.hris.salary.history;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SalaryHistoryDAO {
    private String ueid;
    private int seq;
    private int baseSalary;
    private int performanceBonus;
    private int specialBonus;
    private String salaryComment;
    private String insertAt;
    private String insertBy;
    private String updateAt;
    private String updateBy;

    public static SalaryHistoryDAO applySalaryHistoryDTO(SalaryHistoryDTO salaryHistoryDTO) {
        return SalaryHistoryDAO.builder()
                .ueid(salaryHistoryDTO.getUeid())
                .seq(salaryHistoryDTO.getSeq())
                .baseSalary(salaryHistoryDTO.getBaseSalary())
                .performanceBonus(salaryHistoryDTO.getPerformanceBonus())
                .specialBonus(salaryHistoryDTO.getSpecialBonus())
                .salaryComment(salaryHistoryDTO.getSalaryComment())
                .insertAt(salaryHistoryDTO.getInsertAt())
                .insertBy(salaryHistoryDTO.getInsertBy())
                .updateAt(salaryHistoryDTO.getUpdateAt())
                .updateBy(salaryHistoryDTO.getUpdateBy())
                .build();
    }

    public SalaryHistoryDTO getSalaryHistoryDTO() {
        SalaryHistoryDTO salaryHistoryDTO = new SalaryHistoryDTO();
        salaryHistoryDTO.setUeid(ueid);
        salaryHistoryDTO.setSeq(seq);
        salaryHistoryDTO.setBaseSalary(baseSalary);
        salaryHistoryDTO.setPerformanceBonus(performanceBonus);
        salaryHistoryDTO.setSpecialBonus(specialBonus);
        salaryHistoryDTO.setSalaryComment(salaryComment);
        salaryHistoryDTO.setInsertAt(insertAt);
        salaryHistoryDTO.setInsertBy(insertBy);
        salaryHistoryDTO.setUpdateAt(updateAt);
        salaryHistoryDTO.setUpdateBy(updateBy);

        return salaryHistoryDTO;
    }
}
