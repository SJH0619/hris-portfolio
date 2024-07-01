package com.portfolio.hris.vacation.type;

import lombok.Data;

@Data
public class VacationTypeDTO {
    public String vacationType;
    public String vacationTypeName;
    public String vacationTypeComment;
    public String insertAt;
    public String insertBy;
    public String updateAt;
    public String updateBy;
}
