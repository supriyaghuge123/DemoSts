package com.cjc.main.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data

public class User {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer userId;
	private String userName;
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

}
