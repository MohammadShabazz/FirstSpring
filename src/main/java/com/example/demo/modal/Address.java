package com.example.demo.modal;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="addressss")
public class Address {
	
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String housenumber;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String pincode;

// 
//	  @OneToOne(fetch = FetchType.LAZY, optional = false)
//	  @JoinColumn(name = "user_id",nullable = false,unique = true)
//	  private Account account;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "post_id", nullable = false)
	    @JsonIgnore
	    private Account account;

	
	public Address() {
		super();
	}

	public Address( String housenumber, String street, String city, String state, String pincode) {
		super();
		
		this.housenumber = housenumber;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public void setHousenumber(String housenumber) {
		this.housenumber = housenumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	

	public void setAccount(Account account) {
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}
	

	
	

}
