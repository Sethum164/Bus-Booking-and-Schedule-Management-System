package com.example.tripsystem.features.bus_schedule_management;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BusScheduleRepository extends JpaRepository<BusScheduleModel, Long> {
    List<BusScheduleModel> findByGuideId(Long guideId);
    List<BusScheduleModel> findAll();
    Optional<BusScheduleModel> findById(Long id);
    boolean existsById(Long id);
}