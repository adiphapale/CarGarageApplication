package mvc.cgapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.cgapp.model.AdminModel;
import mvc.cgapp.service.AdminService;

@Controller
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping("/adminloginpage")
	public String adminLogin(@ModelAttribute("admindetails") AdminModel adminModel) {
		return "AdminLoginPage";
	}
	
	@PostMapping("/validamin")
	public String checkAdmin(AdminModel adminModel,Model model) {
		String adminName=adminModel.getAdminName();
		String adminPass=adminModel.getAdminPassword();
		System.out.println(adminName+adminPass);
		boolean res=adminService.checkValidAdmin(adminName, adminPass);
		if(res==true) {
			System.out.println("hii");
			return "redirect:/clientpannel";
		}else {
		model.addAttribute("msg","Invalid Credentials ☹️");
		return "AdminLoginPage";
		}
	}
	
	@RequestMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@RequestMapping("/logoutbtn")
	public String logoutbtn() {
		return "index";
	}

}
