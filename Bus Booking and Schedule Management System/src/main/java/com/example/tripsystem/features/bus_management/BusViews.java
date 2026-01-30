package com.example.tripsystem.features.bus_management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BusViews {
    @GetMapping("/vehicle-management")
    public  String vehicleManagement(){
        return "vehicle-management/vehicle-management";
    }
}
