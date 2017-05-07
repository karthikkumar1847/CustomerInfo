package com.customerInfo.validation;

public class CustomerValidations {

	public CustomerValidations() {
		super();
	}

	public String validateFirstName(String fName) {
		if (isDataFieldBlank(fName))
			return CustomerErrorMessages.USER_FIRST_NAME;
		return "";

	}

	public String validateMiddleName(String mName) {
		if (isDataFieldBlank(mName))
			return CustomerErrorMessages.USER_MIDDLE_NAME;
		return "";

	}

	public String validateLastName(String lName) {
		if (isDataFieldBlank(lName))
			return CustomerErrorMessages.USER_LAST_NAME;
		return "";

	}

	public String validateGender(String gender) {
		if (isGenderNull(gender))
			return CustomerErrorMessages.USER_GENDER;
		return "";

	}

	public String validateAptStreet(String aptStreet) {
		if (isDataFieldBlank(aptStreet))
			return CustomerErrorMessages.USER_Apt_STREET;
		return "";

	}

	public String validateCity(String city) {
		if (isDataFieldBlank(city))
			return CustomerErrorMessages.USER_CITY;
		return "";

	}

	public String validateState(String state) {
		if (isDataFieldBlank(state))
			return CustomerErrorMessages.USER_STATE;
		return "";

	}

	public String validateCountry(String country) {
		if (isDataFieldBlank(country))
			return CustomerErrorMessages.USER_COUNTRY;
		return "";

	}

	public String validatePhone(Long phone) {
		if (isNotValidPhoneNumber(phone))
			return CustomerErrorMessages.USER_PHONE;
		return "";

	}

	public String validateBankName(String bankName) {
		if (isDataFieldBlank(bankName))
			return CustomerErrorMessages.USER_BANK_NAME;
		return "";

	}

	public String validateAccountNumber(String accountNumber) {
		if (isDataFieldBlank(accountNumber))
			return CustomerErrorMessages.USER_ACCOUNT_NUMBER;
		return "";

	}

	public String validateSSN(String ssn) {
		if (isDataFieldBlank(ssn))
			return CustomerErrorMessages.USER_SSN;
		return "";

	}

	private boolean isDataFieldBlank(String str) {

		return str == null || ((String) str).trim().length() <= 2 || ((String) str).isEmpty();
	}
	private boolean isGenderNull(String str) {

		return str == null;
	}
	private boolean isNotValidPhoneNumber(Long l) {

		return String.valueOf(l).length() != 10;
	}
}
