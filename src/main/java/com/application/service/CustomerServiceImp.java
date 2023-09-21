package com.application.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.application.bean.CustomerBean;
import com.application.dao.CustomerRepository;
import com.application.entity.CustomerEntity;

@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerBean> getAllCustomer() {
		// TODO Auto-generated method stub
		List<CustomerBean> customer = new ArrayList<>();
		List<CustomerEntity> details = customerRepository.findAll();
		for (CustomerEntity customerEntity : details) {
			CustomerBean bean = new CustomerBean();
			BeanUtils.copyProperties(customerEntity, bean);
			customer.add(bean);
		}
		return customer;
	}

	public CustomerBean addCustomerdetail(CustomerBean customerBean) {
		// TODO Auto-generated method stub
		CustomerEntity customerEntity = convertBeanToEntity(customerBean);
		CustomerEntity addEntity = customerRepository.save(customerEntity);
		CustomerBean bean = convertEntityToBean(addEntity);
		return bean;
	}
	

	public CustomerBean getCustomerById(int customerId) {
		CustomerBean customer = null;
		CustomerEntity customerEntity = customerRepository.findById(customerId).get();
		if(customerEntity!=null) {
			customer = new CustomerBean();
			BeanUtils.copyProperties(customerEntity, customer);
		}
		return customer;
	}
	
	public CustomerBean updateCustomerdetail(CustomerBean customerBean) {
		CustomerEntity customerEntity = convertBeanToEntity(customerBean);
		CustomerEntity updateEntity = customerRepository.save(customerEntity);
		CustomerBean bean = convertEntityToBean(updateEntity);
		return bean;
	}

	public CustomerBean deleteCustomerdetail(CustomerBean bean) {
		// TODO Auto-generated method stub
		CustomerEntity customerEntity = convertBeanToEntity(bean);
		customerRepository.delete(customerEntity);
		CustomerBean customerBean = convertEntityToBean(customerEntity);
		return customerBean;
	}

	private CustomerBean convertEntityToBean(CustomerEntity addEntity) {
		// TODO Auto-generated method stub
		CustomerBean custBean = new CustomerBean();
		BeanUtils.copyProperties(addEntity, custBean);
		return custBean;
	}

	public CustomerEntity convertBeanToEntity(CustomerBean customerBean) {
		CustomerEntity custEntity = new CustomerEntity();
		BeanUtils.copyProperties(customerBean, custEntity);
		return custEntity;
		
	}

	

	

	
	
	
	
}
