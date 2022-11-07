package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long>{
	
	@Query(value="select * from Bank t where t.id=?1",nativeQuery = true)
	public List<Bank> findBankByCriteria(Long id);

	@Query(value="select * from Bank t where t.id=?1 and t.name=?2",nativeQuery = true)
	public List<Bank> findBankByCriteriaIdName(Long id, String name);

}
