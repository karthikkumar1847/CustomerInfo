package com.customerInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.customerInfo.bo.CustomerBo;
import com.customerInfo.validation.CustomerValidationException;
import com.customerInfo.vo.CustomerInfo;

@Controller
@SessionAttributes("cinfo")
public class CustomerController {
	
	@Autowired
	private CustomerBo customerBo = null;
	
	public CustomerController() {
		super();
	}
	
	@RequestMapping("/pageEntry.go")
	public String displayPerson(Model model){
		System.out.println("Starting of CustomerController: displayPerson(Model model)");
		CustomerInfo cinfo = new CustomerInfo();
		model.addAttribute("cinfo",cinfo);
		System.out.println("Completed CustomerController: displayPerson(Model model)");
		return "person";
	}
	
	@RequestMapping("/person.go")
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
		ModelAndView mv = new ModelAndView("contact");
		return mv;
	}
	@RequestMapping("/contact.go")
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
		ModelAndView mv = new ModelAndView("bank");
		return mv;
	}
	@RequestMapping("/bank.go")
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
		ModelAndView mv = new ModelAndView("success");
		return mv;
	}
}
