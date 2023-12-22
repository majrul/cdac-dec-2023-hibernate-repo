package com.cdac.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int id;
	
	private String name;
	private String email;
	
	@Column(name = "mobile_no")
	private long mobileNumber;
	
	//NO NO NO NO NO NO NO NO NO NO
	//we should never ever map the foreign key column
	//of the table in the Java code directly
	//private int addrId;

	//instead we will keep object reference of target entity
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addr_id") //fk
	private Address address; //has-a

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
