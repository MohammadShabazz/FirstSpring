package com.example.demo.modal;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

@Entity

@Table(name = "users")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstname;

	private String lastname;

	private String dateofbirth;

	private String email;

	private String password;

	private String confirmpassword;

	private String workexperiance;

	private String profession;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
	private ForgotToken forgottoken;

	@Enumerated(EnumType.STRING)
	private GenderType genders;

	public ForgotToken getForgottoken() {
		return forgottoken;
	}

	public void setForgottoken(ForgotToken forgottoken) {
		this.forgottoken = forgottoken;
	}

	@Enumerated(EnumType.STRING)
	private Languagesknown language;

//	 @OneToOne(fetch = FetchType.LAZY,
//	            cascade =  CascadeType.ALL,
//	            mappedBy = "account" )
//	    private Address address;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "account")
	private Set<Address> address = new HashSet<>();

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public Account() {
		super();
	}

	public Account(String firstname, String lastname, String dateofbirth, String email, String password,
			String confirmpassword, String workexperiance, String profession, GenderType genders,
			Languagesknown language) {
		super();

		this.firstname = firstname;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.workexperiance = workexperiance;
		this.profession = profession;
		this.genders = genders;
		this.language = language;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
