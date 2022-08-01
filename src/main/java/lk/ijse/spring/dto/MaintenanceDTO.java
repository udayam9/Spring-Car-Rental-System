package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MaintenanceDTO {
    private String maintenanceId;
    private LocalDate date;
    private LocalDate value;
    private String details;
    private Vehicle vehicle;
}
