package lk.ijse.spring.repo;

import lk.ijse.spring.entity.CarRent;
import lk.ijse.spring.entity.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRequestRepo  extends JpaRepository<RentalRequest, String> {
    @Query(value = "SELECT requestId FROM rentalReuest ORDER BY requestId DESC LIMIT 1",nativeQuery = true)
    String generateRentId();

    List<RentalRequest> getAllByStatus(String status);
}
