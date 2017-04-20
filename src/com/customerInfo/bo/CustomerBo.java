package com.customerInfo.bo;

import com.customerInfo.validation.CustomerValidationException;
import com.customerInfo.vo.CustomerInfo;

public interface CustomerBo {

	public void addCustomerPersonalInfo(CustomerInfo customerInfo) throws CustomerValidationException,Exception;
	public void addCustomerContactInfo(CustomerInfo customerInfo) throws CustomerValidationException,Exception;
	public void addCustomerBankInfo(CustomerInfo customerInfo) throws CustomerValidationException,Exception;
	public void updateCustomer(CustomerInfo customerInfo) throws CustomerValidationException,Exception;
	public CustomerInfo getCustomer(CustomerInfo customerInfo) throws CustomerValidationException,Exception;
	public CustomerInfo deleteCustomer(String ssn) throws CustomerValidationException,Exception;
}
