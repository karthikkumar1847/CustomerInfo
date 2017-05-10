package com.customerInfo.dao;

import java.util.List;

import com.customerInfo.vo.CustomerInfo;

public interface CustomerDao {

	public void addCustomer(CustomerInfo customerInfo);
	public List<CustomerInfo> getCustomer(String actno);
	public List<CustomerInfo> getCustomers();
	public void updateCustomer(CustomerInfo customerInfo);
	public CustomerInfo deleteCustomer(String actno);
}
