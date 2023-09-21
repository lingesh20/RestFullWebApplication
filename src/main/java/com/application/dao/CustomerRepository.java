package com.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.application.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer>{


	

}
