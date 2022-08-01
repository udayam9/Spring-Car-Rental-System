package lk.ijse.spring.entity;

import lk.ijse.spring.embeded.PriceOfRentDuration;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Vehicle {
    @Id
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
    private String registerNumber;
    private double currentMileage;
    private String frontViewImg;
    private String backViewImg;
    private String sideViewImg;
    private String internalViewImg;
    private final boolean availability = true;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<CarRent> rentals = new ArrayList<>();

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<Maintenance> maintenances = new ArrayList<>();

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<RentalRequest> rentalRequestList = new ArrayList<>();

}