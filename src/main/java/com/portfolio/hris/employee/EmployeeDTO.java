package com.portfolio.hris.employee;

import lombok.Data;

@Data
public class EmployeeDTO {
    public String ueid;
    public String employeeId;
    public String password;
    public String name;
    public String gender;
    public String birth;
    public String personalPhoneNumber;
    public String externalTellNumber;
    public String internalTellNumber;
    public String personalEmailAddress;
    public String companyEmailAddress;
    public String departmentCode;
    public String positionCode;
    public String joinDate;
    public String resignDate;
    public String employmentType;
    public String remainingDays;
    public String insertAt;
    public String insertBy;
    public String updateAt;
    public String updateBy;
}
