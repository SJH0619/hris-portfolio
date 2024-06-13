package com.portfolio.hris.attendance;

import lombok.Data;

@Data
public class AttendanceDTO {
    public String ueid;
    public String attendanceDate;
    public String attendanceDay;
    public String arrivalTime;
    public String departureTime;
    public String remarks;
    public String insertAt;
    public String insertBy;
    public String updateAt;
    public String updateBy;
}
