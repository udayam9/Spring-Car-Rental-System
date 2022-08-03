package lk.ijse.spring.service;

import lk.ijse.spring.dto.CarRentDTO;
import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.dto.RentalRequestDTO;

import java.time.LocalDate;
import java.util.List;

public interface RentalRequestService {
    void saveRequest(RentalRequestDTO dto);

    void updateRequest(RentalRequestDTO dto);

    void deleteRequest(String RequestId);

    RentalRequestDTO searchRequest(String RequestId);

    List<RentalRequestDTO> getAllRequest();

    List<RentalRequestDTO> getAllRequestsByDateRange(LocalDate fromDate, LocalDate toDate);

    List<RentalRequestDTO> getAllRequestsByCustomerId(String customerId);
    List<RentalRequestDTO> getRequestByStatus(String status);

    String generateRequestId();
}
