package com.example.tripsystem.features.bus_schedule_management;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BusScheduleViews {

    @GetMapping("/guide-schedule-management")
    public  String guideScheduleAdminView(){
        return "guide-schedule-management/guide-schedule-management";
    }
}
