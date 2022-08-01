package lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import lk.ijse.spring.entity.CarRent;
import lk.ijse.spring.entity.CustomerUserAccount;
import lk.ijse.spring.entity.RentalRequest;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CustomerDTO {
    private String customerId;
    private String email;
    private String nic;
    private String drivingLicence;
    private String address;
    private String contactNumber;
    private CustomerUserAccount customerUserAccount;
    private List<RentalRequest> rentalRequestsList;
    private List<CarRent> carRentList;


}
