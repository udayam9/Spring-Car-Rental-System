package lk.ijse.spring.service;

import lk.ijse.spring.dto.VehicleDTO;
import lk.ijse.spring.service.impl.VehicleServiceImpl;

import java.util.List;

public interface VehicleService {
    void saveCar(VehicleDTO dto);

    void updateCar(VehicleDTO dto);

    void deleteCar(String registrationNO);

    List<VehicleDTO> getAllCars();

    VehicleDTO searchCar(String registrationNO);

    void updateCarStatus(String registrationNO, String status);

    void updateCarFilePaths(String frontImg, String backImg, String interImg, String sideImg, String registrationID);

    List<VehicleDTO> getAllCarsByStatus(String status);

    int getCountOfCarsByStatus(String status);
}
