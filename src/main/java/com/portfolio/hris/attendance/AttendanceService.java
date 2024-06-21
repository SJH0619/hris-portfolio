package com.portfolio.hris.attendance;

import java.util.List;

public interface AttendanceService {
    List<AttendanceDTO> getList();

    List<AttendanceDTO> getListByUeid(String ueid);

    void createAttendance(AttendanceDTO attendanceDTO);

    AttendanceDTO readAttendance(String ueid, String attendanceDate);

    void updateAttendanceInformation(AttendanceDTO attendanceDTO);
}
