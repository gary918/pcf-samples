package com.gary.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AccountRepository extends JpaRepository<Account, Long> {
	
	@Query("SELECT a FROM Account a WHERE a.name=?1")
	Account findByName(String name);

}
