package org.hibernate.example;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Employ implements Serializable{
	@Id
	@GeneratedValue
	Long id;
	String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="employ")
	Address primaryAdd;
	
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="superior")
	Collection<Employ> subEmployees = new HashSet<Employ>();
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	Employ superior;
	
	public Address getPrimaryAdd() {
		return primaryAdd;
	}
	public void setPrimaryAdd(Address primaryAdd) {
		this.primaryAdd = primaryAdd;
	}
	public Collection<Employ> getSubEmployees() {
		return subEmployees;
	}
	public void setSubEmployees(Collection<Employ> subEmployees) {
		this.subEmployees = subEmployees;
	}
	public Employ getSuperior() {
		return superior;
	}
	public void setSuperior(Employ superior) {
		this.superior = superior;
	}
	public Employ() {
		// TODO Auto-generated constructor stub
	}
	public Employ(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
