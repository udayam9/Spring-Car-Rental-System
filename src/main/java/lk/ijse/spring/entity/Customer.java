package lk.ijse.spring.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Customer {
    @Id
    private String customerId;
    private String email;
    private String nic;
    private String drivingLicence;
    private String address;
    private String contactNumber;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    @JoinColumn(name = "userName", referencedColumnName = "userName", nullable = false)
    private CustomerUserAccount customerUserAccount;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<RentalRequest> rentalRequestsList = new ArrayList<RentalRequest>();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<CarRent> carRentList = new ArrayList<CarRent>();

}
