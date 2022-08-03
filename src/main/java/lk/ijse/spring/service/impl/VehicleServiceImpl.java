package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.VehicleDTO;
import lk.ijse.spring.entity.Vehicle;
import lk.ijse.spring.repo.VehicleRepo;
import lk.ijse.spring.service.VehicleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    VehicleRepo repo;

    @Autowired
    ModelMapper mapper;



    @Override
    public void saveCar(VehicleDTO dto) {
        if (!repo.existsById(dto.getRegistrationNO())) {
            repo.save(mapper.map(dto, Vehicle.class));
        } else {
            throw new RuntimeException("Car Already Exists");
        }
    }

    @Override
    public void updateCar(VehicleDTO dto) {
        if (repo.existsById(dto.getRegistrationNO())) {
            repo.save(mapper.map(dto, Vehicle.class));
        } else {
            throw new RuntimeException("No Such Car To Update");
        }
    }
    @Override
    public void deleteCar(String registrationNO) {
        if (repo.existsById(registrationNO)) {
            repo.deleteById(registrationNO);
        } else {
            throw new RuntimeException("No Such Car To Delete");
        }
    }

    @Override
    public List<VehicleDTO> getAllCars() {
        return mapper.map(repo.findAll(), new TypeToken<List<VehicleDTO>>() {
        }.getType());
    }

    @Override
    public VehicleDTO searchCar(String registrationNO) {
        return mapper.map(repo.findById(registrationNO).get(), VehicleDTO.class);
    }

    @Override
    public void updateCarStatus(String registrationNO, String status) {
        if (repo.existsById(registrationNO)) {
            repo.updateCarStatus(status, registrationNO);
        } else {
            throw new RuntimeException("No Such Car To Update");
        }
    }

    @Override
    public void updateCarFilePaths(String frontImg, String backImg, String interImg, String sideImg, String registrationID) {
        if (repo.existsById(registrationID)) {
            repo.updateCarFilePaths(frontImg, backImg, interImg, sideImg, registrationID);
        } else {
            throw new RuntimeException("No Such Car To Update");
        }
    }

    @Override
    public List<VehicleDTO> getAllCarsByStatus(String status) {
        return mapper.map(repo.getAllCarsByStatus(status), new TypeToken<List<VehicleDTO>>() {
        }.getType());
    }

    @Override
    public int getCountOfCarsByStatus(String status) {
        return repo.getCountOfCarsByStatus(status);
    }

}
