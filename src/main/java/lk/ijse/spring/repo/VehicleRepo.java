package lk.ijse.spring.repo;

import lk.ijse.spring.dto.VehicleDTO;
import lk.ijse.spring.entity.CarRent;
import lk.ijse.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface VehicleRepo  extends JpaRepository<Vehicle, String> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Vehicle SET status=:status WHERE registrationNO=:registrationNO", nativeQuery = true)
    void updateCarStatus(@Param("status") String status, @Param("registrationNO") String registrationNO);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Vehicle SET frontViewImg=:frontViewImg,backViewImg=:backViewImg,internalViewImg=:internalViewImg,sideViewImg=:sideViewImg WHERE registrationNO=:registrationNO",nativeQuery = true)
    void updateCarFilePaths(@Param("frontViewImg") String frontViewImg, @Param("backViewImg") String backViewImg, @Param("internalViewImg") String internalViewImg, @Param("sideViewImg") String sideViewImg, @Param("registrationNO") String registrationNO);

    @Query(value = "SELECT * FROM Vehicle WHERE status=:status",nativeQuery = true)
    List<VehicleDTO> getAllCarsByStatus(@Param("status") String status);

    @Query(value = "SELECT COUNT(registrationNO) FROM Vehicle WHERE status=:status",nativeQuery = true)
    int getCountOfCarsByStatus(@Param("status") String status);
}
