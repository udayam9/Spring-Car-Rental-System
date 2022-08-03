package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class RentalRequestDTO {
    private String requestId;
    private Customer customer;
    private Vehicle vehicle;
    private Driver driver;
    private String pickupDateAndTime;
//    private String pickupDateAndTime;
    private Date Date;
    private String status;

}
