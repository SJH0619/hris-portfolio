package com.portfolio.hris.salary;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SalaryDAO {
    private String ueid;
    private String salaryType;
    private String paymentDate;
    private String baseSalary;
    private String performanceBonus;
    private String specialBonus;
    private String insertAt;
    private String insertBy;
    private String updateAt;
    private String updateBy;

    public static SalaryDAO applySalaryDTO(SalaryDTO salaryDTO) {
        return SalaryDAO.builder()
                .ueid(salaryDTO.getUeid())
                .salaryType(salaryDTO.getSalaryType())
                .paymentDate(salaryDTO.getPaymentDate())
                .baseSalary(salaryDTO.getBaseSalary())
                .performanceBonus(salaryDTO.getPerformanceBonus())
                .specialBonus(salaryDTO.getSpecialBonus())
                .insertAt(salaryDTO.getInsertAt())
                .insertBy(salaryDTO.getInsertBy())
                .updateAt(salaryDTO.getUpdateAt())
                .updateBy(salaryDTO.getUpdateBy())
                .build();
    }

    public SalaryDTO getSalaryDTO() {
        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setUeid(ueid);
        salaryDTO.setSalaryType(salaryType);
        salaryDTO.setPaymentDate(paymentDate);
        salaryDTO.setBaseSalary(baseSalary);
        salaryDTO.setPerformanceBonus(performanceBonus);
        salaryDTO.setSpecialBonus(specialBonus);
        salaryDTO.setInsertAt(insertAt);
        salaryDTO.setInsertBy(insertBy);
        salaryDTO.setUpdateAt(updateAt);
        salaryDTO.setUpdateBy(updateBy);

        return salaryDTO;
    }
}
