package com.adem.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adem.entities.Account;

/**
 * Description of the file AccountRepository.java
 * 
 * @author adem
 *
 *         This interface is an extension of JpaRepository interface <br>
 *         It is used to access the Account table which is associated at the
 *         java class Account <br>
 */
public interface AccountRepository extends JpaRepository<Account, String> {

}
