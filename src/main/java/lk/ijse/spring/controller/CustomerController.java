package lk.ijse.spring.controller;

import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCustomers() {
        return new ResponseUtil(200, "Ok", service.getAllCustomers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCustomer(CustomerDTO dto) {
        service.saveCustomer(dto);
        return new ResponseUtil(200, "Saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomer(@RequestBody CustomerDTO dto) {
        service.updateCustomer(dto);
        return new ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteCustomer(@RequestParam String id) {
        service.deleteCustomer(id);
        return new ResponseUtil(200, "Deleted", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomer(@PathVariable String id) {
        System.out.println("kjfjifjoifsfisjfdisjfjfisdidfsjddfsjifdifdjfisdjf");
        return new ResponseUtil(200, "Ok", service.searchCustomer(id));
    }

    @GetMapping(path = "/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchCustomerByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        if (service.findCustomerByUsername(username)) {
            if (service.findCustomerByPassword(password)) {
                return new ResponseUtil(200, "Login Successful", null);
            } else {
                return new ResponseUtil(404, "Incorrect Password", null);
            }
        } else {
            return new ResponseUtil(404, "Incorrect Username", null);
        }
    }

    @GetMapping(path = "/set/{username}/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil findCustomerByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        return new ResponseUtil(200, "Ok", service.findCustomerByUsernameAndPassword(username, password));
    }

    @GetMapping(path = "/generateCustomerId", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil generateCustomerId() {
        return new ResponseUtil(200, "Ok", service.getNewId());
    }

    /*@PutMapping(path = "/updateStatus/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCustomerStatus(@PathVariable String id) {
        service.updateCustomerStatus(id);
        return new ResponseUtil(200, "Updated Status", null);
    }*/

  /*  @GetMapping(path = "/pending", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllPendingCustomers() {
        return new ResponseUtil(200, "Ok", service.getAllPendingCustomers());
    }

    @GetMapping(path = "/accepted", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllAcceptedCustomers() {
        return new ResponseUtil(200, "Ok", service.getAllAcceptedCustomers());
    }*/

    @PutMapping(path = "/up/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil uploadImagesAndPath(@RequestPart("nicf") MultipartFile img,@PathVariable String id) {
        try {
            String projectPath = String.valueOf(new File("/media/kaleesha/Disk D/Easy_Car_Rent"));
            File uploadsDir = new File(projectPath + "/Customers");
            uploadsDir.mkdir();
            img.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + img.getOriginalFilename()));

            String imgPath = projectPath + "/Customers/" + img.getOriginalFilename();

            service.uploadCustomerImages(imgPath, id);

            return new ResponseUtil(200, "Uploaded", null);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseUtil(500, "Error", null);
        }
    }


    @GetMapping(path = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getCountOfRegisteredCustomers() {
        return new ResponseUtil(200, "Ok", service.getCountOfCustomersRegistered());
    }


}