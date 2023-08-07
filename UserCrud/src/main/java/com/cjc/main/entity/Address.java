package com.cjc.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class Address {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer addressId;
	private String areaname;
	private String cityname;
	private String state;
}
