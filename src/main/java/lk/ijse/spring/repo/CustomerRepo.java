package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    @Query(value = "SELECT customerId FROM Customer ORDER BY customerId DESC LIMIT 1", nativeQuery = true)
    String getLastCustomerId();
    Optional<Customer> findCustomerByUsername(String username);

    Optional<Customer> findCustomerByPassword(String password);

    Optional<Customer> findCustomerByUsernameAndPassword(String username, String password);

    @Query(value = "UPDATE Customer SET licenceImg=:licenceImg WHERE customerId=:customerId", nativeQuery = true)
    void updateCustomerFilePaths( @Param("licenceImg") String licenceImg, @Param("customerId") String customerId);

}
