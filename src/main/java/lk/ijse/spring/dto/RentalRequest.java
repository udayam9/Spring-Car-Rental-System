package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.Vehicle;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class RentalRequest {
    private String requestId;
    private Customer customer;
    private Vehicle vehicle;
    private Driver driver;
    private String pickupDateAndTime;
//    private String pickupDateAndTime;
    private java.util.Date Date;
    private String damagePaySlip;
    private double rentPayment;
}
