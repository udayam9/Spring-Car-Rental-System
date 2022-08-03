package lk.ijse.spring.dto;

import lk.ijse.spring.entity.CarRent;
import lk.ijse.spring.entity.Maintenance;
import lk.ijse.spring.entity.RentalRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class VehicleDTO {

    private String vehicleId;
    private String brand;
    private String type;
    private int NumOfPassenger;
    private String transmissionType;
    private String fuelType;
    private String color;
    private double freeMileageForDay;
    private double monthlyRate;
    private String freeMileageForMonth;
    private String priceForExtraKm;
    private String registrationNO;
    private double currentMileage;
    private String frontViewImg;
    private String backViewImg;
    private String sideViewImg;
    private String internalViewImg;
    private String status;
    private final boolean availability = true;
    private List<CarRent> rentals;
    private List<Maintenance> maintenances;
    private List<RentalRequest> rentalRequestList;

}
