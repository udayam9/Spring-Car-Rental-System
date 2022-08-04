package lk.ijse.spring.controller;


import lk.ijse.spring.dto.AdminDTO;
import lk.ijse.spring.dto.CarRentDTO;
import lk.ijse.spring.entity.CarRent;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.service.CarRentService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/carRent")
@CrossOrigin
public class CarRentController {

    @Autowired
    CarRentService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCarRents() {
        return new ResponseUtil(200, "Ok", service.getAllCarRents());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil save(CarRentDTO dto) {
        service.addCarRent(dto);
        return new ResponseUtil(200, "Saved", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil update(@RequestBody CarRentDTO dto) {
        service.updateCarRent(dto);
        return new ResponseUtil(200, "Updated", null);
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil delete(@RequestParam String id) {
        service.deleteCarRent(id);
        return new ResponseUtil(200, "Deleted", null);
    }

    @GetMapping(path = "/generateAdminID")
    public ResponseUtil generateCarRentId() {
        return new ResponseUtil(200, "Ok", service.generateRentId());
    }
}
