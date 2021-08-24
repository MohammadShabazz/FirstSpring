package com.example.demo.Response;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.modal.Address;
import com.example.demo.modal.GenderType;
import com.example.demo.modal.Languagesknown;

public class SignupForm {

	
	private String firstname;
	
	private String lastname;
	
	private String dateofbirth;
	
	private String email;
	
	private String password;
	
	private String confirmpassword;
	
	private String workexperiance;
	
	private String profession;
	

	
	 private Set<String> role;
	 
	 private GenderType genders;
	 
	 private Languagesknown language;
	 
	 
	 
	 private String housenumber;
		
		private String street;
		
		private String city;
		
		private String state;
		
		private String pincode;
		
		
		  private Set<Address> address ;

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getDateofbirth() {
			return dateofbirth;
		}

		public void setDateofbirth(String dateofbirth) {
			this.dateofbirth = dateofbirth;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirmpassword() {
			return confirmpassword;
		}

		public void setConfirmpassword(String confirmpassword) {
			this.confirmpassword = confirmpassword;
		}

		public String getWorkexperiance() {
			return workexperiance;
		}

		public void setWorkexperiance(String workexperiance) {
			this.workexperiance = workexperiance;
		}

		public String getProfession() {
			return profession;
		}

		public void setProfession(String profession) {
			this.profession = profession;
		}

		public Set<String> getRole() {
			return role;
		}

		public void setRole(Set<String> role) {
			this.role = role;
		}

		public GenderType getGenders() {
			return genders;
		}

		public void setGenders(GenderType genders) {
			this.genders = genders;
		}

		public Languagesknown getLanguage() {
			return language;
		}

		public void setLanguage(Languagesknown language) {
			this.language = language;
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

		public Set<Address> getAddress() {
			return address;
		}

		public void setAddress(Set<Address> address) {
			this.address = address;
		}
		


}
