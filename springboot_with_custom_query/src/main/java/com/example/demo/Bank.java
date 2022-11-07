package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name="BankRecord")
public class Bank {
	@Id
	private Long id;
	private String name;
	private String loc;
}
