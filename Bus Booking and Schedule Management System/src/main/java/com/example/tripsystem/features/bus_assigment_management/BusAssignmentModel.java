package com.example.tripsystem.features.bus_assigment_management;

import jakarta.persistence.*;
import com.example.tripsystem.features.booking_management.BookingModel;
import com.example.tripsystem.features.bus_management.BusModel;

@Entity
@Table(name = "vehicle_assignments")
public class BusAssignmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id", nullable = false, unique = true)
    private BookingModel booking;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private BusModel vehicle;

    public BusAssignmentModel() {}

    public BusAssignmentModel(BookingModel booking, BusModel vehicle) {
        this.booking = booking;
        this.vehicle = vehicle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookingModel getBooking() {
        return booking;
    }

    public void setBooking(BookingModel booking) {
        this.booking = booking;
    }

    public BusModel getVehicle() {
        return vehicle;
    }

    public void setVehicle(BusModel vehicle) {
        this.vehicle = vehicle;
    }
}