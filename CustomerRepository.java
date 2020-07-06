package com.boa.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.customer.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
