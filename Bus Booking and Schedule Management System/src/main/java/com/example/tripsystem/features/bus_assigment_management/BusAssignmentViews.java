package com.example.tripsystem.features.bus_assigment_management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BusAssignmentViews {
    @GetMapping("/vehicle-assignments")
    public  String vehicleAssignments(){
        return "vehicle-assignments/vehicle-assignments";
    }
}
