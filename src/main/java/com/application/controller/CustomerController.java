package com.application.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.application.bean.CustomerBean;
import com.application.service.CustomerServiceImp;


@RestController
@RequestMapping(value = "/api/v1")
public class CustomerController {
	

	private CustomerServiceImp customerServiceImp;

	public CustomerController(CustomerServiceImp customerServiceImp) {
		super();
		this.customerServiceImp = customerServiceImp;
	}
	
	@GetMapping(value = "/get/customer")
	public List<CustomerBean> getCustomer(){
		return customerServiceImp.getAllCustomer();
	}
	
	@PostMapping(value = "/add/customer")
	public ResponseEntity<String> addCustomer(@RequestBody CustomerBean customerBean) {
		CustomerBean bean = customerServiceImp.addCustomerdetail(customerBean);
		int id = bean.getCustomerId();
		return new ResponseEntity<String>("Customer details added successfully : "+"Customer id : "+id+
				" Customer name : "+bean.getCustomerName()
				,HttpStatus.CREATED); 
		
	}
	
	@GetMapping(value = "/get/customer/{id}")
	public ResponseEntity<CustomerBean> getCustomerById(@PathVariable("id") int Id){
		CustomerBean bean = customerServiceImp.getCustomerById(Id);
		if(bean!=null) {
			return new ResponseEntity<CustomerBean>(bean,HttpStatus.OK);
		}else {
			return new ResponseEntity<CustomerBean>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping(value = "/update/customer")
	public ResponseEntity<CustomerBean> updateCustomer(@RequestBody CustomerBean customerBean){
		CustomerBean bean = customerServiceImp.getCustomerById(customerBean.getCustomerId());
		if(bean!=null) {
			CustomerBean customer = customerServiceImp.updateCustomerdetail(customerBean);
			return new ResponseEntity<CustomerBean>(customer,HttpStatus.OK);
		}else {
			return new ResponseEntity<CustomerBean>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping(value = "/delete/customer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id){
		CustomerBean bean = customerServiceImp.getCustomerById(id);
		if(bean!=null) {
			CustomerBean customer = customerServiceImp.deleteCustomerdetail(bean);
			return new ResponseEntity<String>("Customer details deleted successfully : "+"Customer id : "
			        +customer.getCustomerId(),HttpStatus.OK); 
		}else {
			return new ResponseEntity<String>("Customer details not found",HttpStatus.NOT_FOUND);
		}
		
	}
	
	

}
