package com.example.tripsystem.features.bus_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusService {

    @Autowired
    private BusRepository vehicleRepository;

    public BusDTOS.VehicleResponse createVehicle(BusDTOS.CreateVehicleRequest request) {
        BusModel vehicle = new BusModel(
                request.getVehicleNumber(),
                request.getType(),
                request.getNumOfSeats(),
                request.getHaveAc(),
                request.getAvailability(),
                request.getDeleteStatus()
        );
        BusModel savedVehicle = vehicleRepository.save(vehicle);
        return convertToVehicleResponse(savedVehicle);
    }

    public Optional<BusDTOS.VehicleResponse> getVehicleById(Long id) {
        return vehicleRepository.findById(id).map(this::convertToVehicleResponse);
    }

    public List<BusDTOS.VehicleResponse> getAllVehicles() {
        return vehicleRepository.findAll().stream()
                .map(this::convertToVehicleResponse)
                .collect(Collectors.toList());
    }

    public List<BusDTOS.VehicleResponse> getActiveVehicles() {
        return vehicleRepository.findByDeleteStatusFalse().stream()
                .map(this::convertToVehicleResponse)
                .collect(Collectors.toList());
    }

    public List<BusDTOS.VehicleResponse> getAvailableVehicles() {
        return vehicleRepository.findByAvailabilityTrueAndDeleteStatusFalse().stream()
                .map(this::convertToVehicleResponse)
                .collect(Collectors.toList());
    }

    public Optional<BusDTOS.VehicleResponse> updateVehicle(Long id, BusDTOS.UpdateVehicleRequest request) {
        return vehicleRepository.findById(id).map(vehicle -> {
            vehicle.setVehicleNumber(request.getVehicleNumber());
            vehicle.setType(request.getType());
            vehicle.setNumOfSeats(request.getNumOfSeats());
            vehicle.setHaveAc(request.getHaveAc());
            vehicle.setAvailability(request.getAvailability());
            vehicle.setDeleteStatus(request.getDeleteStatus());
            BusModel updatedVehicle = vehicleRepository.save(vehicle);
            return convertToVehicleResponse(updatedVehicle);
        });
    }

    public boolean deleteVehicle(Long id) {
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private BusDTOS.VehicleResponse convertToVehicleResponse(BusModel vehicle) {
        return new BusDTOS.VehicleResponse(
                vehicle.getId(),
                vehicle.getVehicleNumber(),
                vehicle.getType(),
                vehicle.getNumOfSeats(),
                vehicle.getHaveAc(),
                vehicle.getAvailability(),
                vehicle.getDeleteStatus()
        );
    }
}