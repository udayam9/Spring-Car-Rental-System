package lk.ijse.spring.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@ToString
@Entity
public class Customer {
    @Id
    private String id;
    private String email;
    private String nic;
    private String drivingLicence;
    private String address;
    private String contactNumber;

    @OneToMany(mappedBy = "customer")
    private List<RentalRequest> rentalRequests = new ArrayList<RentalRequest>();

}
