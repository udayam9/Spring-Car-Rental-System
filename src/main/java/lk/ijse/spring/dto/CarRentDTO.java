package lk.ijse.spring.dto;

import lk.ijse.spring.entity.CarRentReturn;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarRentDTO {
    private String rentId;
    private LocalDate date;
    private LocalDate startMileage;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private String status;
    private CarRentReturn carRentReturn;
    private Customer customer;
    private Vehicle vehicle;
    private Driver driver;
}
