package mvc.cgapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.cgapp.model.CustomerLoginModel;
import mvc.cgapp.service.CustomerLoginService;

@Controller
public class CustomerLoginController {
	CustomerLoginService customerLoginService;
	
	@RequestMapping("/")
	public String customerLoginpage(@ModelAttribute("custlogin") CustomerLoginModel customerLoginModel) {
		
		return "customerloginpage";
		
	}
	
	@PostMapping("/")
	public String Custometlogin(CustomerLoginModel customerLoginModel) {
		
		boolean b=customerLoginService.isCustomerLogoin(customerLoginModel);
		if(b) {
			return "";
		}
		else {
			return "";
		}

	}
	
	
}
