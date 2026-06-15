package com.example.SpringBootTask8.Repository;

import com.example.SpringBootTask8.Entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public class VehicleRepository {


    public interface vehicleRepository extends JpaRepository<Vehicle,Long>{

    }
}
