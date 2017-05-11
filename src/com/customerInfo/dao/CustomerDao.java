package com.customerInfo.dao;

import java.util.List;

import com.customerInfo.vo.CustomerInfo;

public interface CustomerDao {

	public void addCustomer(CustomerInfo customerInfo);
	public CustomerInfo getCustomer(String actno);
	public List<CustomerInfo> getCustomers();
	public void updateCustomer(String actno,CustomerInfo customerInfo);
	public String deleteCustomer(String actno);
}
