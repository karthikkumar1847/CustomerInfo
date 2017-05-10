package com.customerInfo.bo;

import java.util.List;

import com.customerInfo.validation.CustomerValidationException;
import com.customerInfo.vo.CustomerInfo;
import com.sun.mail.iap.Response;

public interface CustomerBo {

	public void addCustomerPersonalInfo(CustomerInfo customerInfo) throws CustomerValidationException,Exception;
	public void addCustomerContactInfo(CustomerInfo customerInfo) throws CustomerValidationException,Exception;
	public void addCustomerBankInfo(CustomerInfo customerInfo) throws CustomerValidationException,Exception;	
	public List<CustomerInfo> getCustomer(String actno)throws CustomerValidationException,Exception;
	public List<CustomerInfo> getCustomers() throws CustomerValidationException,Exception;
	public CustomerInfo updateCustomer(CustomerInfo customerInfo) throws CustomerValidationException,Exception;
	public CustomerInfo deleteCustomer(String actno) throws CustomerValidationException,Exception;
}
