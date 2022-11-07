package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class BankController {

	@Autowired
	BankRepository bankRepository;
	
	@GetMapping("/allbanks")
	public List<Bank> getBank() {
		List<Bank> bankList=(List<Bank>) bankRepository.findAll();
		return bankList;
	}
	
	@PostMapping("/savebank")
	public Bank saveBank(@RequestBody Bank bank) {
		Bank bank1=bankRepository.save(bank);
		return bank1;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBank(@PathVariable Long id) {
		bankRepository.deleteById(id);
		return "Record deleted sucessfully";
	}
   
	@PutMapping("/updateBank")
	public Bank updateBank(@RequestBody Bank bank) {
		Optional<Bank> dbRecord=bankRepository.findById(bank.getId());
		
		// update record as per ui
		Bank bank1=dbRecord.get();
		bank1.setName(bank.getName());
		bank1.setLoc(bank.getLoc());
		
		// save back to database
		bankRepository.save(bank1);
		return bank1;
	}
	
	@GetMapping("/getbank/{id}")
	public List<Bank> getAllBankCriteria(@PathVariable Long id){
		List<Bank> bnkList=bankRepository.findBankByCriteria(id);
		return bnkList;
	}
	
	
	@GetMapping("/getbank/{id}/{name}")
	public List<Bank> getAllBankCriteriaIdName(@PathVariable Long id,@PathVariable String name){
		List<Bank> bnkList=bankRepository.findBankByCriteriaIdName(id,name);
		return bnkList;
	}
}
