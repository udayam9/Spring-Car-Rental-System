package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.CustomerUserAccount;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.CustomerUserAccountRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private CustomerUserAccountRepo customerUserAccountRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void saveCustomer(CustomerDTO customer) {
        if (!repo.existsById(customer.getId())){

            repo.save(mapper.map(customer,Customer.class));

            if (!customerUserAccountRepo.existsById(customer.getUserName())) {
                //CustomerUserAccount customerUserAccount = new CustomerUserAccount(customer.getUserName(),customer.getPassword(),mapper.map(customer,Customer.class));
                customerUserAccountRepo.save(mapper.map(customer,CustomerUserAccount.class));
            }else{
                throw new RuntimeException("UserAccount Already Exit");
            }

        }else{
            throw new RuntimeException("Customer Already Exit");
        }
    }
}
