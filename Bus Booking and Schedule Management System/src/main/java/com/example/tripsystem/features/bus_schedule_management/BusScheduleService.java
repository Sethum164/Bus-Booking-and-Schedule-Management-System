package com.example.tripsystem.features.bus_schedule_management;

import com.example.tripsystem.features.user_management.UserModel;
import com.example.tripsystem.features.user_management.UserRepository;
import com.example.tripsystem.features.booking_management.BookingModel;
import com.example.tripsystem.features.booking_management.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusScheduleService {

    @Autowired
    private BusScheduleRepository guideScheduleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    public BusScheduleDTOS.GuideScheduleResponse createGuideSchedule(BusScheduleDTOS.CreateGuideScheduleRequest request) {
        UserModel guide = userRepository.findById(request.getGuideId()).orElseThrow(() -> new RuntimeException("Guide not found"));
        BookingModel booking = bookingRepository.findById(request.getBookingId()).orElseThrow(() -> new RuntimeException("Booking not found"));

        BusScheduleModel schedule = new BusScheduleModel(guide, booking);
        BusScheduleModel savedSchedule = guideScheduleRepository.save(schedule);
        return convertToResponse(savedSchedule);
    }

    public Optional<BusScheduleDTOS.GuideScheduleResponse> getGuideScheduleById(Long id) {
        return guideScheduleRepository.findById(id).map(this::convertToResponse);
    }

    public List<BusScheduleDTOS.GuideScheduleResponse> getAllGuideSchedules() {
        return guideScheduleRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public List<BusScheduleDTOS.GuideScheduleResponse> getGuideSchedulesByGuideId(Long guideId) {
        return guideScheduleRepository.findByGuideId(guideId).stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public Optional<BusScheduleDTOS.GuideScheduleResponse> updateGuideSchedule(Long id, BusScheduleDTOS.UpdateGuideScheduleRequest request) {
        return guideScheduleRepository.findById(id).map(schedule -> {
            UserModel guide = userRepository.findById(request.getGuideId()).orElseThrow(() -> new RuntimeException("Guide not found"));
            BookingModel booking = bookingRepository.findById(request.getBookingId()).orElseThrow(() -> new RuntimeException("Booking not found"));

            schedule.setGuide(guide);
            schedule.setBooking(booking);
            BusScheduleModel updatedSchedule = guideScheduleRepository.save(schedule);
            return convertToResponse(updatedSchedule);
        });
    }

    public boolean deleteGuideSchedule(Long id) {
        if (guideScheduleRepository.existsById(id)) {
            guideScheduleRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private BusScheduleDTOS.GuideScheduleResponse convertToResponse(BusScheduleModel schedule) {
        UserModel guide = schedule.getGuide();
        BookingModel booking = schedule.getBooking();
        return new BusScheduleDTOS.GuideScheduleResponse(
                schedule.getId(),
                guide.getId(),
                guide.getFirstName() + " " + guide.getLastName(),
                guide.getEmail(),
                booking.getId(),
                booking.getBookingDate()
        );
    }
}