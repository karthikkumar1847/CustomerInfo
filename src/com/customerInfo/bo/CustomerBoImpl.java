package com.customerInfo.bo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.customerInfo.dao.CustomerDao;
import com.customerInfo.validation.CustomerValidationException;
import com.customerInfo.validation.CustomerValidations;
import com.customerInfo.vo.CustomerInfo;

@Service
public class CustomerBoImpl implements CustomerBo {

	@Autowired
	private CustomerDao customerDao = null;
	
	public CustomerBoImpl() {
		super();
	}

	@Override
	public void addCustomerPersonalInfo(CustomerInfo customerInfo) throws CustomerValidationException, Exception {
		System.out.println("Starting of CustomerBoImpl: addCustomerPersonalInfo(CustomerInfo customerInfo)");
		StringBuffer sbf = new StringBuffer();
		CustomerValidations customervalidation = new CustomerValidations();
		sbf.append(customervalidation.validateFirstName(customerInfo.getFirstName()));
		sbf.append(customervalidation.validateMiddleName(customerInfo.getMiddleName()));
		sbf.append(customervalidation.validateLastName(customerInfo.getLastName()));
		sbf.append(customervalidation.validateGender(customerInfo.getGender()));
		
		if(sbf.length()!=0){
			CustomerValidationException exception = new CustomerValidationException(sbf.toString());
			throw exception;
		}
		System.out.println("Completed CustomerBoImpl: addCustomerPersonalInfo(CustomerInfo customerInfo)");
	}

	@Override
	public void addCustomerContactInfo(CustomerInfo customerInfo) throws CustomerValidationException, Exception {
		System.out.println("Starting of CustomerBoImpl: addCustomerContactInfo(CustomerInfo customerInfo)");
		StringBuffer sbf = new StringBuffer();
		CustomerValidations customervalidation = new CustomerValidations();
		sbf.append(customervalidation.validateAptStreet(customerInfo.getApt()));
		sbf.append(customervalidation.validateCity(customerInfo.getCity()));
		sbf.append(customervalidation.validateState(customerInfo.getState()));
		sbf.append(customervalidation.validateCountry(customerInfo.getCountry()));
		sbf.append(customervalidation.validatePhone(customerInfo.getPhoneNumber()));
		
		if(sbf.length()!=0){
			CustomerValidationException exception = new CustomerValidationException(sbf.toString());
			throw exception;
		}
		System.out.println("Completed CustomerBoImpl: addCustomerContactInfo(CustomerInfo customerInfo)");
		
	}

	@Override
	public void addCustomerBankInfo(CustomerInfo customerInfo) throws CustomerValidationException, Exception {

		System.out.println("Starting of CustomerBoImpl: addCustomerBankInfo(CustomerInfo customerInfo)");
		StringBuffer sbf = new StringBuffer();
		CustomerValidations customervalidation = new CustomerValidations();
		sbf.append(customervalidation.validateBankName(customerInfo.getBankName()));
		sbf.append(customervalidation.validateAccountNumber(customerInfo.getAccountNumber()));
		sbf.append(customervalidation.validateSSN(customerInfo.getSsn()));
		
		if(sbf.length()!=0){
			CustomerValidationException exception = new CustomerValidationException(sbf.toString());
			throw exception;
		}else{
			customerDao.addCustomer(customerInfo);
		}
		System.out.println("Completed CustomerBoImpl: addCustomerBankInfo(CustomerInfo customerInfo)");
	
	}
	
	@Override
	public String insertCustomer(CustomerInfo customerInfo) {
		return customerDao.addCustomer(customerInfo);
	}

	@Override
	public CustomerInfo getCustomer(String actno) throws CustomerValidationException, Exception{
		System.out.println("Completed CustomerBoImpl: getCustomer(String actno)");
		System.out.println("Completed CustomerBoImpl: getCustomer(String actno)");
		return customerDao.getCustomer(actno);
	}

	@Override
	public List<CustomerInfo> getCustomers() throws CustomerValidationException, Exception {
		System.out.println("Starting of CustomerBoImpl: getCustomers()");
		System.out.println("Completed CustomerBoImpl: getCustomers()");
		return customerDao.getCustomers();
	}

	@Override
	public String updateCustomer(String ssn,CustomerInfo customerInfo) throws CustomerValidationException, Exception {
		
		System.out.println("Starting of CustomerBoImpl: updateCustomer(String ssn, CustomerInfo customerInfo)");
		
		System.out.println("Completed CustomerBoImpl: updateCustomer(String ssn, CustomerInfo customerInfo)");
		return customerDao.updateCustomer(ssn,customerInfo);
	}
	
	@Override
	public String deleteCustomer(String ssn) throws CustomerValidationException, Exception {
		System.out.println("Starting of CustomerBoImpl: deleteCustomer(String ssn)");
		System.out.println("Completed CustomerBoImpl: deleteCustomer(String ssn)");
		return customerDao.deleteCustomer(ssn);
	}

}