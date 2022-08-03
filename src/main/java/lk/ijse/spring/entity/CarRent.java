package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class CarRent {
    @Id
    private String rentId;
    private LocalDate date;
    private LocalDate startMileage;
    private LocalDate pickUpDate;
    private LocalDate returnDate;
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "returnId", referencedColumnName = "returnId", nullable = false)
    private CarRentReturn carRentReturn;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requestId", referencedColumnName = "requestId", nullable = false)
    private RentalRequest rentalRequest;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "vehicleId", referencedColumnName = "vehicleId", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "driverId", referencedColumnName = "driverId", nullable = false)
    private Driver driver;
}