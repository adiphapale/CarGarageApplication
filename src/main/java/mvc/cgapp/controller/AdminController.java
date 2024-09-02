package mvc.cgapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	@RequestMapping("/adminlogin")
	public String adminLogin() {
		
		return "adminLogin";
	}

}
