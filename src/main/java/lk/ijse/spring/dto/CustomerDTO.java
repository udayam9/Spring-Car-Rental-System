package lk.ijse.spring.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.*;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Data
@ToString
public class CustomerDTO {
    @Id
    private String id;
    private String email;
    private String nic;
    private String drivingLicence;
    private String address;
    private String contactNumber;
    private String userName;
    private String password;
    //private CustomerUserAccDTO customerUserAccDTO;


}
