package com.example.tripsystem.features.bus_assigment_management;

import com.example.tripsystem.features.booking_management.BookingModel;
import com.example.tripsystem.features.booking_management.BookingRepository;
import com.example.tripsystem.features.user_management.UserModel;
import com.example.tripsystem.features.bus_management.BusModel;
import com.example.tripsystem.features.bus_management.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusAssignmentService {

    @Autowired
    private BusAssignmentRepository vehicleAssignmentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BusRepository vehicleRepository;

    public BusAssignmentDTOS.VehicleAssignmentResponse createVehicleAssignment(BusAssignmentDTOS.CreateVehicleAssignmentRequest request) {
        BookingModel booking = bookingRepository.findById(request.getBookingId()).orElseThrow(() -> new RuntimeException("Booking not found"));
        BusModel vehicle = vehicleRepository.findById(request.getVehicleId()).orElseThrow(() -> new RuntimeException("Vehicle not found"));

        BusAssignmentModel assignment = new BusAssignmentModel(booking, vehicle);
        BusAssignmentModel savedAssignment = vehicleAssignmentRepository.save(assignment);
        return convertToResponse(savedAssignment);
    }

    public Optional<BusAssignmentDTOS.VehicleAssignmentResponse> getVehicleAssignmentById(Long id) {
        return vehicleAssignmentRepository.findById(id).map(this::convertToResponse);
    }

    public List<BusAssignmentDTOS.VehicleAssignmentResponse> getAllVehicleAssignments() {
        return vehicleAssignmentRepository.findAll().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public Optional<BusAssignmentDTOS.VehicleAssignmentResponse> updateVehicleAssignment(Long id, BusAssignmentDTOS.UpdateVehicleAssignmentRequest request) {
        return vehicleAssignmentRepository.findById(id).map(assignment -> {
            BookingModel booking = bookingRepository.findById(request.getBookingId()).orElseThrow(() -> new RuntimeException("Booking not found"));
            BusModel vehicle = vehicleRepository.findById(request.getVehicleId()).orElseThrow(() -> new RuntimeException("Vehicle not found"));

            assignment.setBooking(booking);
            assignment.setVehicle(vehicle);
            BusAssignmentModel updatedAssignment = vehicleAssignmentRepository.save(assignment);
            return convertToResponse(updatedAssignment);
        });
    }

    public boolean deleteVehicleAssignment(Long id) {
        if (vehicleAssignmentRepository.existsById(id)) {
            vehicleAssignmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private BusAssignmentDTOS.VehicleAssignmentResponse convertToResponse(BusAssignmentModel assignment) {
        BookingModel booking = assignment.getBooking();
        UserModel customer = booking.getCustomer();
        BusModel vehicle = assignment.getVehicle();
        return new BusAssignmentDTOS.VehicleAssignmentResponse(
                assignment.getId(),
                booking.getId(),
                customer.getFirstName() + " " + customer.getLastName(),
                customer.getEmail(),
                vehicle.getId(),
                vehicle.getVehicleNumber(),
                vehicle.getType()
        );
    }
}