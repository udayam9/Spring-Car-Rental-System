package lk.ijse.spring.repo;

import lk.ijse.spring.entity.CarRent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRequestRepo  extends JpaRepository<RentalRequestRepo, String> {
}
