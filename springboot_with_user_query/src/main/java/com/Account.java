package com;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@ToString
@EqualsAndHashCode
public class Account {
@Id	
private Integer accountid;
private String name;
private String loc;
private Float amount;
}
