package com.customerInfo.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.customerInfo.util.HibernateConnector;
import com.customerInfo.vo.CustomerInfo;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	public static Logger logger=Logger.getLogger(CustomerDaoImpl.class);
	
	
	@Override
	public void addCustomer(CustomerInfo customerInfo) {
		//PropertyConfigurator.configure("log4j.properties");
		 logger.info("Starting of CustomerDaoImpl: addCustomer(CustomerInfo customerInfo)");
		System.out.println("Starting of CustomerDaoImpl: addCustomer(CustomerInfo customerInfo)");
		Session session = HibernateConnector.getInstance().getSession();
		Transaction tx = session.beginTransaction();
		session.save(customerInfo);
		tx.commit();
		session.close();
		System.out.println("Completed CustomerDaoImpl: addCustomer(CustomerInfo customerInfo)");
		logger.info("Completed CustomerDaoImpl: addCustomer(CustomerInfo customerInfo)");
	}

	@Override
	public void updateCustomer(CustomerInfo customerInfo) {
		System.out.println("Starting of CustomerDaoImpl: updateCustomer(CustomerInfo customerInfo)");
		System.out.println("Completed CustomerDaoImpl: updateCustomer(CustomerInfo customerInfo)");
	}

	@Override
	public List<CustomerInfo> getCustomers() {
		System.out.println("Starting of CustomerDaoImpl: getCustomer(CustomerInfo customerInfo)");
		Session session = HibernateConnector.getInstance().getSession();
		Transaction tx = session.beginTransaction();
		List<CustomerInfo> list = session.createCriteria(CustomerInfo.class).list();
		//List<CustomerInfo> list = (List<CustomerInfo>)session.createSQLQuery("SELECT * FROM customerinfotable")
		//			.addEntity(CustomerInfo.class).list();
		tx.commit();
		session.close();
		System.out.println("Completed CustomerDaoImpl: getCustomer(CustomerInfo customerInfo)");
		return list;
	}

	@Override
	public CustomerInfo deleteCustomer(String ssn) {
		System.out.println("Starting of CustomerDaoImpl: deleteCustomer(String ssn))");
		System.out.println("Completed CustomerDaoImpl: deleteCustomer(String ssn)");
	
		return null;
	}

}
