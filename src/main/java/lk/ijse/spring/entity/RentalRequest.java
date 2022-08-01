package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class RentalRequest {
    @Id
    private String requestId;

    @ManyToOne
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicleId", referencedColumnName = "vehicleId", nullable = false)
    private Vehicle vehicle;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driverId", referencedColumnName = "driverId", nullable = false)
    private Driver driver;

    private String pickupDateAndTime;
//    private String pickupDateAndTime;

    @CreationTimestamp
    private Date Date;

    private String damagePaySlip;

    private double rentPayment;
}
