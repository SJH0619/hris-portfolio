package com.portfolio.hris.vacation;

import lombok.Data;

@Data
public class VacationDTO {
    public String ueid;
    public int seq;
    public String vacationType;
    public String startDate;
    public String endDate;
    public int usingDays;
    public int remainingDays;
    public String vacationPurpose;
    public String approvalResponsibility;
    public String vacationRequestDate;
    public String vacationApprovalDate;
    public String insertAt;
    public String insertBy;
    public String updateAt;
    public String updateBy;
}
