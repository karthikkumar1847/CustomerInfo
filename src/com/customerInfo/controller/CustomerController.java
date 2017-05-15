package com.customerInfo.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.customerInfo.bo.CustomerBo;
import com.customerInfo.validation.CustomerValidationException;
import com.customerInfo.vo.CustomerInfo;
import com.customerInfo.vo.ListCustomerInfo;

/**
 * @author Karthik Kumar
 *
 */
@RestController
@SessionAttributes(value = "cinfo", types = {CustomerInfo.class})
public class CustomerController {
	private static Logger logger=Logger.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerBo customerBo = null;
	
	public CustomerController() {
		super();
	}
	
	@RequestMapping(value="/pageEntry.go",method = RequestMethod.GET)
	public ModelAndView displayPerson(Model model){
		 System.out.println("Starting of CustomerController: displayPerson(Model model)");
		
		CustomerInfo cinfo = new CustomerInfo();
		model.addAttribute("cinfo",cinfo);
		
		System.out.println("Completed CustomerController: displayPerson(Model model)");
		logger.info("displayPerson Method executed.");
		
		ModelAndView mv = new ModelAndView("person");
		return mv;
	}
	
	@RequestMapping(value = "/person.go", method = RequestMethod.POST)
	public ModelAndView displayContact(@ModelAttribute("cinfo")CustomerInfo cinfo){
		System.out.println("Starting of CustomerController:  displayContact(@ModelAttribute(\"cinfo\")CustomerInfo cinfo)");
		String errors = "";
		try{
			customerBo.addCustomerPersonalInfo(cinfo);
		}catch(CustomerValidationException exception){
			errors = exception.getErrorMessage();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Completed CustomerController:  displayContact(@ModelAttribute(\"cinfo\")CustomerInfo cinfo)");
		if(!errors.equals("")){
			ModelAndView mv = new ModelAndView("person");
			mv.addObject("errors", errors);
			return mv;
		}
		logger.info("displayContact method executed.");
		ModelAndView mv = new ModelAndView("contact");
		return mv;
	}
	
	@RequestMapping(value = "/contact.go", method = RequestMethod.POST)
	public ModelAndView displayBank(@ModelAttribute("cinfo")CustomerInfo cinfo){
		System.out.println("Starting of CustomerController: displayBank(@ModelAttribute(\"cinfo\")CustomerInfo cinfo)");
		String errors = "";
		try {
			customerBo.addCustomerContactInfo(cinfo);
		} catch(CustomerValidationException exception){
			errors = exception.getErrorMessage();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Completed CustomerController: displayBank(@ModelAttribute(\"cinfo\")CustomerInfo cinfo)");
		if(!errors.equals("")){
			ModelAndView mv = new ModelAndView("contact");
			mv.addObject("errors", errors);
			return mv;
		}
		logger.info("displayBank method executed.");
		ModelAndView mv = new ModelAndView("bank");
		return mv;
	}
	
	@RequestMapping(value = "/bank.go", method = RequestMethod.POST)
	public ModelAndView displayOutput(@ModelAttribute("cinfo")CustomerInfo cinfo){
		System.out.println("Starting of CustomerController: displayOutput(@ModelAttribute(\"cinfo\")CustomerInfo cinfo)");
		String errors = "";
		try {
			customerBo.addCustomerBankInfo(cinfo);
		} catch (CustomerValidationException exception) {
			errors = exception.getErrorMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Completed CustomerController: displayOutput(@ModelAttribute(\"cinfo\")CustomerInfo cinfo)");
		if(!errors.equals("")){
			ModelAndView mv = new ModelAndView("bank");
			mv.addObject("errors", errors);
			return mv;
		}
		logger.info("displayOutput method executed.");
		ModelAndView mv = new ModelAndView("success");
		return mv;
	}
	
	@RequestMapping(value = "/insertCustomer.go", method = RequestMethod.POST, consumes = {"application/json","application/xml"})
	public ResponseEntity<CustomerInfo> insertCustomer(@RequestBody CustomerInfo customerInfo) throws CustomerValidationException, Exception{
		 String s =  customerBo.insertCustomer(customerInfo);	
		 if(s.equals("success"))
				return new ResponseEntity<CustomerInfo>(HttpStatus.CREATED);
			else
				return new ResponseEntity<CustomerInfo>(HttpStatus.FOUND);
	}
	
	@RequestMapping(value = "/{actno}/getCustomer/xml.go",method = RequestMethod.GET, produces = {"application/xml"})
	public ResponseEntity<CustomerInfo> getCustomerXml(@PathVariable String actno) throws CustomerValidationException, Exception{
		CustomerInfo customer = customerBo.getCustomer(actno);	
		if(customer != null)
			return new ResponseEntity<CustomerInfo>(customer,HttpStatus.OK);
		else
			return new ResponseEntity<CustomerInfo>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/{actno}/getCustomer/json.go",method = RequestMethod.GET, produces = {"application/json"})
	public ResponseEntity<CustomerInfo> getCustomerJson(@PathVariable String actno) throws CustomerValidationException, Exception{
		CustomerInfo customer = customerBo.getCustomer(actno);	
		if(customer != null)
			return new ResponseEntity<CustomerInfo>(customer,HttpStatus.OK);
		else
			return new ResponseEntity<CustomerInfo>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/getAllCustomers/json.go",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CustomerInfo>> getCustomersJson() throws CustomerValidationException, Exception{
		List<CustomerInfo> customer =  customerBo.getCustomers();	
		if(!customer.isEmpty())
			return new ResponseEntity<List<CustomerInfo>>(customer,HttpStatus.OK);
		else
			return new ResponseEntity<List<CustomerInfo>>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/getAllCustomers/xml.go",method = RequestMethod.GET, produces = "application/xml")
	public ResponseEntity<ListCustomerInfo> getCustomersXml() throws CustomerValidationException, Exception{
		ListCustomerInfo customers =  new ListCustomerInfo();
		customers.setCustomers(customerBo.getCustomers());
		if(! customers.getCustomers().isEmpty())
			return new ResponseEntity<ListCustomerInfo>(customers,HttpStatus.OK);
		else
			return new ResponseEntity<ListCustomerInfo>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/{ssn}/updateCustomer.go", method = RequestMethod.PUT, consumes = {"application/json","application/xml"})
	public ResponseEntity<CustomerInfo> updateCustomer(@PathVariable String ssn,@RequestBody CustomerInfo customerInfo) throws CustomerValidationException, Exception{
		String s = customerBo.updateCustomer(ssn,customerInfo);	
		if(s.equals("success"))
			return new ResponseEntity<CustomerInfo>(HttpStatus.OK);
		else
			return new ResponseEntity<CustomerInfo>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/{ssn}/deleteCustomer.go",method = RequestMethod.DELETE)
	public ResponseEntity<CustomerInfo> deleteCustomer(@PathVariable String ssn) throws CustomerValidationException, Exception{
		String s = customerBo.deleteCustomer(ssn);
		if(s.equals("success"))
			return new ResponseEntity<CustomerInfo>(HttpStatus.OK);
		else
			return new ResponseEntity<CustomerInfo>(HttpStatus.NOT_FOUND);
	}
	
}
