package com.customerInfo.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="customerinfotable",uniqueConstraints = {@UniqueConstraint(columnNames = {"actno"})})
@XmlRootElement(name="customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	private String firstName ;
	@XmlElement
	private String lastName ;
	@XmlElement
	private String middleName ;
	@XmlElement
	private String gender ;
	@XmlElement
	private String apt ;
	@XmlElement
	private String city ;
	@XmlElement
	private String state ;
	@XmlElement
	private String country;
	@XmlElement
	private Long phoneNumber ;
	@XmlElement
	private String bankName;
	@XmlElement
	private String accountNumber ;
	@XmlAttribute
	private String ssn ;
	
	public CustomerInfo() {
		super();
		
	}

	@Column(name="fname")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="lName")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="mName")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	@Column(name="gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
			this.gender = gender;
	}
	
	@Column(name="aptStreet")
	public String getApt() {
		return apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	@Column(name="city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="state")
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name="country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name="phno")
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name="bankName")
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name="actno", unique=true)
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Id
	@Column(name="ssn")
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
}
