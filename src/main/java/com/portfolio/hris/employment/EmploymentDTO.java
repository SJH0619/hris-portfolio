package com.portfolio.hris.employment;

import lombok.Data;

@Data
public class EmploymentDTO {
    public String employmentType;
    public String employmentName;
    public String employmentComment;
    public String insertAt;
    public String insertBy;
    public String updateAt;
    public String updateBy;
}
