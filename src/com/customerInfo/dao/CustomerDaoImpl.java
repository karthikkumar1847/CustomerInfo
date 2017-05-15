package com.customerInfo.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.customerInfo.util.HibernateConnector;
import com.customerInfo.vo.CustomerInfo;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	public static Logger logger = Logger.getLogger(CustomerDaoImpl.class);

	@SuppressWarnings({ "finally" })
	@Override
	public String addCustomer(CustomerInfo customerInfo) {
		logger.info("Starting of CustomerDaoImpl: addCustomer(CustomerInfo customerInfo)");
		String res = "";
		System.out.println("Starting of CustomerDaoImpl: addCustomer(CustomerInfo customerInfo)");
		Session session = HibernateConnector.getInstance().getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(customerInfo);
			tx.commit();
			res = "success";
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			res = "fail";
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("Completed CustomerDaoImpl: addCustomer(CustomerInfo customerInfo)");
			logger.info("Completed CustomerDaoImpl: addCustomer(CustomerInfo customerInfo)");
			return res;
		}
	}

	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public CustomerInfo getCustomer(String actno) {
		System.out.println("Starting of CustomerDaoImpl: getCustomer(String actno)");
		Session session = HibernateConnector.getInstance().getSession();
		Transaction tx = null;
		List<CustomerInfo> list = null;
		try {
			tx = session.beginTransaction();
			Criteria cr = session.createCriteria(CustomerInfo.class);
			cr.add(Restrictions.eq("accountNumber", actno));
			list = cr.list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("Completed CustomerDaoImpl: getCustomer(String actno)");
			if(list.isEmpty())
				return null;
			else
				return list.get(0);
		}
	}

	@Override
	@SuppressWarnings({ "unchecked", "finally" })
	public List<CustomerInfo> getCustomers() {
		System.out.println("Starting of CustomerDaoImpl: getCustomers()");
		Session session = HibernateConnector.getInstance().getSession();
		Transaction tx = null;
		List<CustomerInfo> list = null;
		try {
			tx = session.beginTransaction();
			list = session.createCriteria(CustomerInfo.class).list();
			// List<CustomerInfo> list =
			// (List<CustomerInfo>)session.createSQLQuery("SELECT * FROM
			// customerinfotable")
			// .addEntity(CustomerInfo.class).list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("Completed CustomerDaoImpl: getCustomers()");
			if(!list.isEmpty())
				return list;
			else 
				return null;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String updateCustomer(String ssn, CustomerInfo customerInfo) {
		System.out.println("Starting of CustomerDaoImpl: updateCustomer(String actno, CustomerInfo customerInfo)");
		String res = "";
		Session session = HibernateConnector.getInstance().getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			CustomerInfo update = (CustomerInfo) session.load(CustomerInfo.class, ssn);
			/*
			  Criteria cr = session.createCriteria(CustomerInfo.class);
			  cr.add(Restrictions.eq("ssn", ssn)); List<CustomerInfo> list =
			  cr.list(); CustomerInfo update = list.get(0);
			 */
			if (update.getSsn().equals(ssn)) {
				update.setFirstName(customerInfo.getFirstName());
				update.setMiddleName(customerInfo.getMiddleName());
				update.setLastName(customerInfo.getLastName());
				update.setGender(customerInfo.getGender());
				update.setApt(customerInfo.getApt());
				update.setCity(customerInfo.getCity());
				update.setState(customerInfo.getState());
				update.setCountry(customerInfo.getCountry());
				update.setPhoneNumber(customerInfo.getPhoneNumber());
				update.setBankName(customerInfo.getBankName());
				update.setAccountNumber(customerInfo.getAccountNumber());
				update.setSsn(customerInfo.getSsn());
				session.update(update);
				tx.commit();
				res = "success";
			} else {
				res = "fail";
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("Completed CustomerDaoImpl: updateCustomer(String actno, CustomerInfo customerInfo)");
			return res;
		}
	}

	@SuppressWarnings("finally")
	@Override
	public String deleteCustomer(String ssn) {
		String res = "";
		System.out.println("Starting of CustomerDaoImpl: deleteCustomer(String ssn))");
		Session session = HibernateConnector.getInstance().getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();

			CustomerInfo customer = (CustomerInfo) session.load(CustomerInfo.class, ssn);
			if (customer.getSsn().equals(ssn)) {
				session.delete(customer);
				tx.commit();
				res = "success";
			} else {
				res = "fail";
			}

		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			System.out.println("Completed CustomerDaoImpl: deleteCustomer(String ssn)");
			return res;
		}
	}
}
