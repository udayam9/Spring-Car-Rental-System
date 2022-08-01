package lk.ijse.spring.dto;

import lk.ijse.spring.entity.CarRent;
import lk.ijse.spring.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString

public class CarRentReturnDTO {
    private String returnId;
    private LocalDate date;
    private String endMileage;
    private double noOfKm;
    private CarRent carRent;
    private Payment payment;

}
