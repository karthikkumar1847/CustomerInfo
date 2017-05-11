package com.customerInfo.dao;

import java.util.List;

import com.customerInfo.vo.CustomerInfo;

public interface CustomerDao {

	public String addCustomer(CustomerInfo customerInfo);
	public CustomerInfo getCustomer(String actno);
	public List<CustomerInfo> getCustomers();
	public String updateCustomer(String actno,CustomerInfo customerInfo);
	public String deleteCustomer(String actno);
}
