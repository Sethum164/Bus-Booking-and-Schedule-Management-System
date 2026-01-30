package com.example.tripsystem.features.bus_assigment_management;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BusAssignmentRepository extends JpaRepository<BusAssignmentModel, Long> {
    Optional<BusAssignmentModel> findByBookingId(Long bookingId);
    List<BusAssignmentModel> findAll();
    boolean existsById(Long id);
}