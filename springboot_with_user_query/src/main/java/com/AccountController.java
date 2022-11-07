package com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acc")
public class AccountController {

	@Autowired
	AccountRepository accountRepository;

	@GetMapping("/all")
	public List<Account> getAllAccount() {
		List<Account> accList = accountRepository.findAll();

		return accList;
	}

	@PostMapping("/save")
	public Account saveAccount(@RequestBody Account account) {
		accountRepository.save(account);
		return account;
	}

	@GetMapping("/crt/{amt}")
	public List<Account> getAccountByCriteria(@PathVariable("amt") Float amount) {
		/*
		 * List<Account> accList = accountRepository.findAll(); List<Account> filterList
		 * = accList.stream().filter(x -> x.getAmount() >
		 * amount).collect(Collectors.toList());
		 */
		List<Account> accList=accountRepository.filterAccountByAmount(amount);
	
		return accList;
	}
	
	@GetMapping("/crt/{amount}/{name}")
	public List<Account> getAccountByAmountName(@PathVariable Float amount,@PathVariable String name) {
		
		/*
		 * List<Account> accList = accountRepository.findAll(); List<Account> filterList
		 * = accList.stream(). filter(x -> x.getAmount() >=amount &&
		 * x.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
		 */
		
		List<Account> filterList=accountRepository.filterAccountByAmountName(name,amount);
		return filterList;
	}
	
	
	@GetMapping("/crt")
	public List<Account> getAccountByQueryParam(@RequestParam("amt") Float amount) {
		/*
		 * List<Account> accList = accountRepository.findAll(); List<Account> filterList
		 * = accList.stream().filter(x -> x.getAmount() >
		 * amount).collect(Collectors.toList());
		 */
		List<Account> accList=accountRepository.filterAccountByAmount(amount);
	
		return accList;
	}


}
