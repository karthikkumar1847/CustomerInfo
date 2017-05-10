package com.customerInfo.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.customerInfo.bo.CustomerBo;
import com.customerInfo.validation.CustomerValidationException;
import com.customerInfo.vo.CustomerInfo;

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
	
	@RequestMapping(value = "/{actno}/getCustomer.go",method = RequestMethod.GET, produces = "application/json")
	public List<CustomerInfo> getCustomer(@PathVariable String actno) throws CustomerValidationException, Exception{
		return customerBo.getCustomer(actno);	
	}
	
	@RequestMapping(value = "/getCustomers.go",method = RequestMethod.GET, produces = "application/json")
	public List<CustomerInfo> getCustomers() throws CustomerValidationException, Exception{
		return customerBo.getCustomers();	
	}
	
	@RequestMapping(value = "/{actno}/deleteCustomer.go",method = RequestMethod.DELETE, produces = "application/json")
	public CustomerInfo deleteCustomer(@PathVariable String actno) throws CustomerValidationException, Exception{
		return null;	
	}
	
	@RequestMapping(value = "/editCustomer.go",method = RequestMethod.PUT, consumes = "application/json")
	public CustomerInfo updateCustomer(CustomerInfo customerInfo) throws CustomerValidationException, Exception{
		return customerBo.updateCustomer(customerInfo);	
	}
}
