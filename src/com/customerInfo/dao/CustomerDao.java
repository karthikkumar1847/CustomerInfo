package com.customerInfo.dao;

import java.util.List;

import com.customerInfo.vo.CustomerInfo;

public interface CustomerDao {

	public void addCustomer(CustomerInfo customerInfo);
	public void updateCustomer(CustomerInfo customerInfo);
	public List<CustomerInfo> getCustomers();
	public CustomerInfo deleteCustomer(String ssn);
}
