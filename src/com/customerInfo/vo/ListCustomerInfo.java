package com.customerInfo.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customers")
public class ListCustomerInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<CustomerInfo> customers = new ArrayList<CustomerInfo>();

	public List<CustomerInfo> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerInfo> customers) {
		this.customers = customers;
	}
}
