package com.masai.heybroker.controller;

import com.masai.heybroker.model.Admin;
import com.masai.heybroker.model.Customer;
import com.masai.heybroker.model.Property;
import com.masai.heybroker.service.AdminService;
import com.masai.heybroker.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomerHandler(@RequestBody Customer customer){

       Customer customer1 =  customerService.createCustomer(customer);

       return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);
    }
    @PutMapping("/update/{key}")
    public ResponseEntity<Customer>updateCustomerHandler(@RequestBody Customer customer, @PathVariable String key){

        Customer customer1 =  customerService.updateCustomer(customer,key);

          return new ResponseEntity<Customer>(customer1,HttpStatus.OK);
    }

    @GetMapping("/profile/{key}")
    public ResponseEntity<Customer> getProfileHandler(@PathVariable String key){

        Customer customer=customerService.getProfile(key);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @GetMapping("/propertybytype/{key}/{propertytype}")
    public ResponseEntity<List<Property>> getProfileHandler(@PathVariable String key, @PathVariable String propertytype){

        List<Property> properties=customerService.viewPropertyByPropertyType(key,propertytype);

        return new ResponseEntity<>(properties,HttpStatus.OK);
    }
    @GetMapping("/viewallproperty/{key}")
	public ResponseEntity<List<Property>> viewAllPropertyHandler(@PathVariable String key){

		List<Property> property1=customerService.viewAllProperty(key);

		return new ResponseEntity<>(property1,HttpStatus.OK);
	}

}
