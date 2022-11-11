package com.adem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adem.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
