package com.example.tripsystem.features.bus_management;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<BusModel, Long> {
    Optional<BusModel> findByVehicleNumber(String vehicleNumber);
    List<BusModel> findByDeleteStatusFalse();
    List<BusModel> findByAvailabilityTrueAndDeleteStatusFalse();
    List<BusModel> findByTypeAndDeleteStatusFalse(String type);
}