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
public class CarRentReturn {
    @Id
    private String returnId;
    private LocalDate date;
    private String endMileage;
    private double noOfKm;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rentId", referencedColumnName = "rentId", nullable = false)
    private CarRent carRent;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentId", referencedColumnName = "paymentId", nullable = false)
    private Payment payment;
}
