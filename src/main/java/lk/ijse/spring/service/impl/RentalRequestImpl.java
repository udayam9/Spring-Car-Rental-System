package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.dto.RentalRequestDTO;
import lk.ijse.spring.entity.RentalRequest;
import lk.ijse.spring.repo.RentalRequestRepo;
import lk.ijse.spring.service.RentalRequestService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Transactional
@Service

public class RentalRequestImpl implements RentalRequestService {
    @Autowired
    RentalRequestRepo repo;

    @Autowired
    ModelMapper mapper;

    @Override
    public void saveRequest(RentalRequestDTO dto) {
        if (!repo.existsById(dto.getRequestId())) {
            repo.save(mapper.map( dto, lk.ijse.spring.entity.RentalRequest.class));
        } else {
            throw new RuntimeException("Booking Already Exists...");
        }
    }

    @Override
    public void updateRequest(RentalRequestDTO dto) {
        if (repo.existsById(dto.getRequestId())) {
            repo.save(mapper.map(dto, RentalRequest.class));
        } else {
            throw new RuntimeException("No Such Request To Update");
        }
    }

    @Override
    public void deleteRequest(String RequestId) {
        if (repo.existsById(RequestId)){
            repo.deleteById(RequestId);
        }else {
            throw new RuntimeException("No Such Request To Delete");
        }
    }

    @Override
    public RentalRequestDTO searchRequest(String RequestId) {
        if (repo.existsById(RequestId)){
            return mapper.map(repo.findById(RequestId).get(), RentalRequestDTO.class);
        }else {
            throw new RuntimeException("Driver Not Found...");
        }
    }

    @Override
    public List<RentalRequestDTO> getAllRequest() {
        return null;
    }

    @Override
    public List<RentalRequestDTO> getAllRequestsByDateRange(LocalDate fromDate, LocalDate toDate) {
        return mapper.map(repo.findAll(), new TypeToken<List<RentalRequestDTO>>() {
        }.getType());
    }

    @Override
    public List<RentalRequestDTO> getAllRequestsByCustomerId(String customerId) {
        return null;
    }

    @Override
    public List<RentalRequestDTO> getRequestByStatus(String status) {
        return mapper.map(repo.getAllByStatus(status), new TypeToken<List<RentalRequestDTO>>() {
        }.getType());    }

    @Override
    public String generateRequestId() {
            String lastId = repo.generateRentId();
            String id = "";

            if (lastId != null) {
                int tempId = Integer.parseInt(lastId.split("-")[1]);
                tempId = tempId + 1;
                if (tempId <= 9) {
                    id = "RQ0-000" + tempId;
                } else if (tempId <= 99) {
                    id = "RQ0-00" + tempId;
                } else if (tempId <= 999) {
                    id = "RQ0-0" + tempId;
                } else if (tempId <= 9999) {
                    id = "RQ0-" + tempId;
                }
            } else {
                id = "RQ0-0001";
            }
            return id;
        }}

