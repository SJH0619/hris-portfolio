package com.portfolio.hris.employee;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
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
    private String jobTitleCode;
    private String joinDate;
    private String resignDate;
    private String employmentType;
    private String remainingDays;
    private String insertAt;
    private String insertBy;
    private String updateAt;
    private String updateBy;

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
        employeeDTO.setJobTitleCode(jobTitleCode);
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
