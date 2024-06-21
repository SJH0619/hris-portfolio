package com.portfolio.hris.attendance;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttendanceMapper {
    List<AttendanceDAO> getList();

    List<AttendanceDAO> getListByUeid(String ueid);

    void createAttendance(AttendanceDAO attendanceDAO);

    AttendanceDAO getAttendanceByUeidAndAttendanceDate(String ueid, String attendanceDate);

    void updateAttendanceInformation(AttendanceDAO attendanceDAO);
}
