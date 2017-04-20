package com.customerInfo.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.customerInfo.util.HibernateConnector;
import com.customerInfo.vo.CustomerInfo;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	@Override
	public void addCustomer(CustomerInfo customerInfo) {
		System.out.println("Starting of CustomerDaoImpl: addCustomer(CustomerInfo customerInfo)");
		Session session = HibernateConnector.getInstance().getSession();
		Transaction tx = session.beginTransaction();
		session.save(customerInfo);
		tx.commit();
		session.close();
		System.out.println("Completed CustomerDaoImpl: addCustomer(CustomerInfo customerInfo)");
	}

	@Override
	public void updateCustomer(CustomerInfo customerInfo) {
		System.out.println("Starting of CustomerDaoImpl: updateCustomer(CustomerInfo customerInfo)");
		System.out.println("Completed CustomerDaoImpl: updateCustomer(CustomerInfo customerInfo)");
	}

	@Override
	public CustomerInfo getCustomer(CustomerInfo customerInfo) {
		System.out.println("Starting of CustomerDaoImpl: getCustomer(CustomerInfo customerInfo)");
		System.out.println("Completed CustomerDaoImpl: getCustomer(CustomerInfo customerInfo)");
	
		return null;
	}

	@Override
	public CustomerInfo deleteCustomer(String ssn) {
		System.out.println("Starting of CustomerDaoImpl: deleteCustomer(String ssn))");
		System.out.println("Completed CustomerDaoImpl: deleteCustomer(String ssn)");
	
		return null;
	}

}
