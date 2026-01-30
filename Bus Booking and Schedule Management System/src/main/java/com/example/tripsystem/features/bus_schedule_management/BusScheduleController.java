package com.example.tripsystem.features.bus_schedule_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guide-schedules")
public class BusScheduleController {

    @Autowired
    private BusScheduleService guideScheduleService;

    @PostMapping
    public ResponseEntity<?> createGuideSchedule(@RequestBody BusScheduleDTOS.CreateGuideScheduleRequest request) {
        try {
            BusScheduleDTOS.GuideScheduleResponse response = guideScheduleService.createGuideSchedule(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating guide schedule: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGuideScheduleById(@PathVariable Long id) {
        try {
            Optional<BusScheduleDTOS.GuideScheduleResponse> schedule = guideScheduleService.getGuideScheduleById(id);
            if (schedule.isPresent()) {
                return ResponseEntity.ok(schedule.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Guide schedule not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving guide schedule: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllGuideSchedules() {
        try {
            List<BusScheduleDTOS.GuideScheduleResponse> schedules = guideScheduleService.getAllGuideSchedules();
            return ResponseEntity.ok(schedules);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving guide schedules: " + e.getMessage());
        }
    }

    @GetMapping("/guide/{guideId}")
    public ResponseEntity<?> getGuideSchedulesByGuideId(@PathVariable Long guideId) {
        try {
            List<BusScheduleDTOS.GuideScheduleResponse> schedules = guideScheduleService.getGuideSchedulesByGuideId(guideId);
            return ResponseEntity.ok(schedules);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving guide schedules: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateGuideSchedule(@PathVariable Long id, @RequestBody BusScheduleDTOS.UpdateGuideScheduleRequest request) {
        try {
            Optional<BusScheduleDTOS.GuideScheduleResponse> updatedSchedule = guideScheduleService.updateGuideSchedule(id, request);
            if (updatedSchedule.isPresent()) {
                return ResponseEntity.ok(updatedSchedule.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Guide schedule not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating guide schedule: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGuideSchedule(@PathVariable Long id) {
        try {
            boolean deleted = guideScheduleService.deleteGuideSchedule(id);
            if (deleted) {
                return ResponseEntity.ok("Guide schedule deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Guide schedule not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting guide schedule: " + e.getMessage());
        }
    }
}