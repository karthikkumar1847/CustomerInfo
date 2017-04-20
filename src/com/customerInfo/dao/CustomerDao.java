package com.customerInfo.dao;

import com.customerInfo.vo.CustomerInfo;

public interface CustomerDao {

	public void addCustomer(CustomerInfo customerInfo);
	public void updateCustomer(CustomerInfo customerInfo);
	public CustomerInfo getCustomer(CustomerInfo customerInfo);
	public CustomerInfo deleteCustomer(String ssn);
}
