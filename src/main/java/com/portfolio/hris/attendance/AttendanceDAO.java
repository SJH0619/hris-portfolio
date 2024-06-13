package com.portfolio.hris.attendance;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AttendanceDAO {
    private String ueid;
    private String attendanceDate;
    private String attendanceDay;
    private String arrivalTime;
    private String departureTime;
    private String remarks;
    private String insertAt;
    private String insertBy;
    private String updateAt;
    private String updateBy;

    public static AttendanceDAO applyAttendanceDTO(AttendanceDTO attendanceDTO) {
        return AttendanceDAO.builder()
                .ueid(attendanceDTO.getUeid())
                .attendanceDate(attendanceDTO.getAttendanceDate())
                .attendanceDay(attendanceDTO.getAttendanceDay())
                .arrivalTime(attendanceDTO.getArrivalTime())
                .departureTime(attendanceDTO.getDepartureTime())
                .remarks(attendanceDTO.getRemarks())
                .insertAt(attendanceDTO.getInsertAt())
                .insertBy(attendanceDTO.getInsertBy())
                .updateAt(attendanceDTO.getUpdateAt())
                .updateBy(attendanceDTO.getUpdateBy())
                .build();
    }

    public AttendanceDTO getAttendanceDTO() {
        AttendanceDTO attendanceDTO = new AttendanceDTO();
        attendanceDTO.setUeid(ueid);
        attendanceDTO.setAttendanceDate(attendanceDate);
        attendanceDTO.setAttendanceDay(attendanceDay);
        attendanceDTO.setArrivalTime(arrivalTime);
        attendanceDTO.setDepartureTime(departureTime);
        attendanceDTO.setRemarks(remarks);
        attendanceDTO.setInsertAt(insertAt);
        attendanceDTO.setInsertBy(insertBy);
        attendanceDTO.setUpdateAt(updateAt);
        attendanceDTO.setUpdateBy(updateBy);

        return attendanceDTO;
    }
}
