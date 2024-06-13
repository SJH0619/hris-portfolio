package com.portfolio.hris.attendance;

import java.util.List;

public interface AttendanceService {
    List<AttendanceDTO> getList();

    void createAttendance(AttendanceDTO attendanceDTO);

    AttendanceDTO readAttendance(String ueid, String attendanceDate);

    void updateAttendanceInformation(AttendanceDTO attendanceDTO);
}
