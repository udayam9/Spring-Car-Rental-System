package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO var1);
    void updateCustomer(CustomerDTO var1);
//    List<CarDTO> viewCars();
//    void rentalRequest(RentalRequestDTO var1);
    void existUserCustomerAccount(String var1);
    void existEmail(String var1);
    String getNewId();
    void checkUserAccount(String var1, String var2);
}
