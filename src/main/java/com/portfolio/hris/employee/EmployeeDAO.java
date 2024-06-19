package com.portfolio.hris.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDAO {
    private String ueid;
    private String employeeId;
    private String password;
    private String name;
    private String gender;
    private String birth;
    private String personalPhoneNumber;
    private String externalTellNumber;
    private String internalTellNumber;
    private String personalEmailAddress;
    private String companyEmailAddress;
    private String departmentCode;
    private String positionCode;
    private String joinDate;
    private String resignDate;
    private String employmentType;
    private String remainingDays;
    private String insertAt;
    private String insertBy;
    private String updateAt;
    private String updateBy;

    public static EmployeeDAO applyEmployeeDTO(EmployeeDTO employeeDTO) {
        return EmployeeDAO.builder()
                .ueid(employeeDTO.getUeid())
                .employeeId(employeeDTO.getEmployeeId())
                .password(employeeDTO.getPassword())
                .name(employeeDTO.getName())
                .gender(employeeDTO.getGender())
                .birth(employeeDTO.getBirth())
                .personalPhoneNumber(employeeDTO.getPersonalPhoneNumber())
                .externalTellNumber(employeeDTO.getExternalTellNumber())
                .internalTellNumber(employeeDTO.getInternalTellNumber())
                .personalEmailAddress(employeeDTO.getPersonalEmailAddress())
                .companyEmailAddress(employeeDTO.getCompanyEmailAddress())
                .departmentCode(employeeDTO.getDepartmentCode())
                .positionCode(employeeDTO.getPositionCode())
                .joinDate(employeeDTO.getJoinDate())
                .resignDate(employeeDTO.getResignDate())
                .employmentType(employeeDTO.getEmploymentType())
                .remainingDays(employeeDTO.getRemainingDays())
                .insertAt(employeeDTO.getInsertAt())
                .insertBy(employeeDTO.getInsertBy())
                .updateAt(employeeDTO.getUpdateAt())
                .updateBy(employeeDTO.getUpdateBy())
                .build();
    }

    public EmployeeDTO getEmployeeDTO() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setUeid(ueid);
        employeeDTO.setEmployeeId(employeeId);
        employeeDTO.setPassword(password);
        employeeDTO.setName(name);
        employeeDTO.setGender(gender);
        employeeDTO.setBirth(birth);
        employeeDTO.setPersonalPhoneNumber(personalPhoneNumber);
        employeeDTO.setExternalTellNumber(externalTellNumber);
        employeeDTO.setInternalTellNumber(internalTellNumber);
        employeeDTO.setPersonalEmailAddress(personalEmailAddress);
        employeeDTO.setCompanyEmailAddress(companyEmailAddress);
        employeeDTO.setDepartmentCode(departmentCode);
        employeeDTO.setPositionCode(positionCode);
        employeeDTO.setJoinDate(joinDate);
        employeeDTO.setResignDate(resignDate);
        employeeDTO.setEmploymentType(employmentType);
        employeeDTO.setRemainingDays(remainingDays);
        employeeDTO.setInsertAt(insertAt);
        employeeDTO.setInsertBy(insertBy);
        employeeDTO.setUpdateAt(updateAt);
        employeeDTO.setUpdateBy(updateBy);

        return employeeDTO;
    }
}
