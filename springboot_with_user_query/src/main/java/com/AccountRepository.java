package com;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Integer> {

	@Query(value="select * from account where amount>=?1",nativeQuery = true)
	public List<Account> filterAccountByAmount(Float amount);
	
	@Query(value="select * from account where amount>=?2 and name=?1",nativeQuery = true)
    public List<Account> filterAccountByAmountName(String name,Float amount);
	
}
