package lk.ijse.spring.dto;

import lk.ijse.spring.entity.CarRent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DriverDTO {
    private String driverId;
    private String licenceNo;
    private String name;
    private String address;
    private int contactNo;
    private String nic;
    private String username;
    private String password;
    private boolean availability = true;
    private List<CarRent> rentals;

}
