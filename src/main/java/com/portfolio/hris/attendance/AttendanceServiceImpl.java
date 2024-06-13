package com.portfolio.hris.attendance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceMapper attendanceMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AttendanceDTO> getList() {
        List<AttendanceDAO> resource = attendanceMapper.getList();
        List<AttendanceDTO> result = new ArrayList<>();

        resource.forEach(attendance -> result.add(attendance.getAttendanceDTO()));

        return result;
    }

    @Override
    @Transactional
    public void createAttendance(AttendanceDTO attendanceDTO) {
        AttendanceDAO attendanceDAO = AttendanceDAO.applyAttendanceDTO(attendanceDTO);

        attendanceMapper.createAttendance(attendanceDAO);
    }

    @Override
    @Transactional(readOnly = true)
    public AttendanceDTO readAttendance(String ueid, String attendanceDate) {
        AttendanceDAO attendanceDAO = attendanceMapper.getAttendanceByUeidAndAttendanceDate(ueid, attendanceDate);

        return attendanceDAO.getAttendanceDTO();
    }

    @Override
    @Transactional
    public void updateAttendanceInformation(AttendanceDTO attendanceDTO) {
        AttendanceDAO attendanceDAO = AttendanceDAO.applyAttendanceDTO(attendanceDTO);

        attendanceMapper.updateAttendanceInformation(attendanceDAO);
    }
}
