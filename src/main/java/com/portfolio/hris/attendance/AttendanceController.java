package com.portfolio.hris.attendance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @GetMapping("/list")
    public String getAttendanceList(Model model) {
        model.addAttribute("attendanceList", attendanceService.getList());

        return "/attendance/list";
    }

    @PostMapping("/create")
    public String createAttendance(AttendanceDTO attendanceDTO) {
        attendanceService.createAttendance(attendanceDTO);

        return "redirect:/attendance/list";
    }

    @GetMapping("/read/{ueid}/{attendanceDate}")
    public String readAttendance(@PathVariable("ueid") String ueid,
                                 @PathVariable("attendanceDate") String attendanceDate,
                                 Model model) {
        model.addAttribute("attendance", attendanceService.readAttendance(ueid, attendanceDate));

        return "/attendance/read";
    }

    @PostMapping("/update")
    public String updateAttendanceInformation(AttendanceDTO attendanceDTO) {
        attendanceService.updateAttendanceInformation(attendanceDTO);

        return "redirect:/attendance/read/" + attendanceDTO.getUeid() + "/" + attendanceDTO.getAttendanceDate();
    }
}
