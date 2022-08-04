package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.CustomerUserAccount;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.repo.CustomerUserAccountRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Autowired
    private CustomerUserAccountRepo customerUserAccountRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void saveCustomer(CustomerDTO customer) {
        if (!repo.existsById(customer.getCustomerId())){

            repo.save(mapper.map(customer,Customer.class));

            if (!customerUserAccountRepo.existsById(customer.getCustomerUserAccount().getUserName())) {
                //CustomerUserAccount customerUserAccount = new CustomerUserAccount(customer.getUserName(),customer.getPassword(),mapper.map(customer,Customer.class));
                customerUserAccountRepo.save(mapper.map(customer,CustomerUserAccount.class));
            }else{
                throw new RuntimeException("UserName Already Exit");
            }

        }else{
            throw new RuntimeException("Customer Already Exit");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapper.map(repo.findAll(), new TypeToken<List<CustomerDTO>>() {
        }.getType());
    }
    @Override
    public CustomerDTO searchCustomer(String customerId) {
        if (repo.existsById(customerId)) {
            return mapper.map(repo.findById(customerId).get(), CustomerDTO.class);
        } else {
            throw new RuntimeException("No Such Customer");
        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        if (repo.existsById(customerId)) {
            repo.deleteById(customerId);
        } else {
            throw new RuntimeException("No Such Customer To Delete");
        }
    }

    @Override
    public void updateCustomer(CustomerDTO customer) {
        if (repo.existsById(customer.getCustomerId())){

            repo.save(mapper.map(customer,Customer.class));
                customerUserAccountRepo.save(customer.getCustomerUserAccount());

            }
        else{
            throw new RuntimeException("Customer Not Exit");
        }
    }

    @Override
    public void existUserCustomerAccount(String var1) {


    }

    @Override
    public void existEmail(String var1) {

    }

    @Override
    public String getNewId(){
    String lastId = repo.getLastCustomerId();
    String id = "";

        if (lastId != null) {
        int tempId = Integer.parseInt(lastId.split("-")[1]);
        tempId = tempId + 1;
        if (tempId <= 9) {
            id = "C00-000" + tempId;
        } else if (tempId <= 99) {
            id = "C00-00" + tempId;
        } else if (tempId <= 999) {
            id = "C00-0" + tempId;
        } else if (tempId <= 9999) {
            id = "C00-" + tempId;
        }
    } else {
        id = "C00-0001";
    }
        return id;

    }

    @Override
    public void checkUserAccount(String var1, String var2) {

    }
    @Override
    public boolean findCustomerByUsername(String username) {
        return repo.findCustomerByUsername(username).isPresent();
    }

    @Override
    public boolean findCustomerByPassword(String password) {
        return repo.findCustomerByPassword(password).isPresent();
    }

    @Override
    public CustomerDTO findCustomerByUsernameAndPassword(String username, String password) {
        return mapper.map(repo.findCustomerByUsernameAndPassword(username, password).get(), CustomerDTO.class);
    }

    @Override
    public void uploadCustomerImages(String photoPath,String id) {
        if (repo.existsById(id)) {
            repo.updateCustomerFilePaths(photoPath, id);
        } else {
            throw new RuntimeException("Customer Not Found");
        }
    }
    @Override
    public int getCountOfCustomersRegistered() {
        return repo.countByCustomerId();
    }
}
