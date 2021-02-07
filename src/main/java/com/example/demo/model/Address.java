package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Address implements Serializable{
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int addressId; 
	
	private String city;
	private String state;
	private int pincode;
	
	@OneToOne(targetEntity=User.class)
	@MapsId
	@JoinColumn(name="Users_ID")
	@JsonIgnoreProperties("address")
	private User user;
	
	public String getCity() {
		return city;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String city, String state, int pincode) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", state=" + state + ", pincode=" + pincode
				 + "]";
	}

	
}
