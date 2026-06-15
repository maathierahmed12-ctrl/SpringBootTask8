package com.example.SpringBootTask8.Services;

import com.example.SpringBootTask8.Entities.Vehicle;
import com.example.SpringBootTask8.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class VehicleManager {

    @Autowired
    private VehicleRepository vehicleRepository;
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }
    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicleDetails) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found with id: " + id));


        return vehicleRepository.save(vehicle);
    }
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
