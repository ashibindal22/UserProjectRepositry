package com.example.demo.response.dto;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.model.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@SuppressWarnings("serial")
public class UserDto implements Serializable{
	
	private String name;
	
	@JsonIgnoreProperties("user")
	private Optional<Address> address;
	private String email;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(String name, Optional<Address> address, String email) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Optional<Address> getAddress() {
		return address;
	}

	public void setAddress(Optional<Address> address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", City=" + address.get().getCity() + ", email=" + 
				email + ", State=" +address.get().getState() + ", Pincode=" +address.get().getPincode() + "]";
	}
	
}
