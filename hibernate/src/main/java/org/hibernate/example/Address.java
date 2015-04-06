package org.hibernate.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Address {
	@Id
	@GeneratedValue
	Long id;
	
	//@OneToOne(mappedBy="primaryAdd")
//	Employ employ;
	String city;
	Integer pinCode;


public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
//public Employ getEmploy() {
//	return employ;
//}
//public void setEmploy(Employ employ) {
//	this.employ = employ;
//}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Integer getPinCode() {
	return pinCode;
}
public void setPinCode(Integer pinCode) {
	this.pinCode = pinCode;
}

}
