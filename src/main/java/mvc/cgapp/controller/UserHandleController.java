package mvc.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.cgapp.model.CommonVDetailsModel;
import mvc.cgapp.model.TechniciansModel;
import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.model.UserVehicleModel;
import mvc.cgapp.model.VisitVehicleModel;
import mvc.cgapp.service.TechniciansService;
import mvc.cgapp.service.UserService;
import mvc.cgapp.service.UserVehicleService;

@Controller
public class UserHandleController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserVehicleService userVehicleService;
	
	@Autowired
	TechniciansService techniciansService;
	
	@RequestMapping("/clientpannel")
	public String clientPannel(@ModelAttribute("userDetails") UserDetailsModel userDetailsModel) {
		return "clientPannel";
	}

	@PostMapping("/processform")
	public String processForm(UserDetailsModel userDetailsModel, Model model) {
		if(userDetailsModel.getUsername().isEmpty()&&userDetailsModel.getUsercontact().isEmpty()&&userDetailsModel.getUseremail().isEmpty()&&userDetailsModel.getUseraddress().isEmpty()) {
			
			List<UserDetailsModel> gettingAllUsers=userService.getAllUser();
			model.addAttribute("users",gettingAllUsers);
		}
		else {
			model.addAttribute("userinfo",userDetailsModel);
			
			List<UserDetailsModel> gettingSelectedUsers=userService.getSelectedUsers(userDetailsModel);
			model.addAttribute("users",gettingSelectedUsers);
		}
		return "clientPannel";
	}
	
	@RequestMapping("/updateSave")
	public String AddUpdateUser(@RequestParam("userID") int id,Model model) {
		
		System.out.println(id);
		UserDetailsModel selectedUser=userService.getSelectedUsersByID(id);
//		System.out.println(selectedUser);
		model.addAttribute("userinfo",selectedUser);
		
		List<UserVehicleModel> getAllSelectedVehicles=userVehicleService.getVehiclesByUserID(id);
	
		model.addAttribute("vehicles",getAllSelectedVehicles);
		return "userAddUpdate";
	}
	
	@RequestMapping("/goingtoupdate")
	public String updatedUser(UserDetailsModel userDetailsModel,Model model) {
		
		UserDetailsModel olddetails=userService.getSelectedUsersByID(userDetailsModel.getUserid());
		
		UserDetailsModel gettingUpdatedUser=userService.getUpdatedUser(userDetailsModel);
		
		if(olddetails.getUsername().equals(gettingUpdatedUser.getUsername())&&
				olddetails.getUsercontact().equals(gettingUpdatedUser.getUsercontact())&&
				olddetails.getUseremail().equals(gettingUpdatedUser.getUseremail())&&
				olddetails.getUseraddress().equals(gettingUpdatedUser.getUseraddress())) {
			model.addAttribute("userinfo",olddetails);
		}
		else {
			model.addAttribute("msg","Updated !");
			model.addAttribute("userinfo",gettingUpdatedUser);
		}
		
		List<UserVehicleModel> getAllSelectedVehicles=userVehicleService.getVehiclesByUserID(userDetailsModel.getUserid());
		
		model.addAttribute("vehicles",getAllSelectedVehicles);
		return "userAddUpdate";

	}
	
	
	@RequestMapping("/addnewcustomer")
	public String addNewCustomerPage(@ModelAttribute("CustDetails") UserDetailsModel userDetailsModel,
			@ModelAttribute("UserVehicleModel") UserVehicleModel uservehicleModel,
			@ModelAttribute("VisitVehicleModel") VisitVehicleModel visitVehicleModel,Model model) {
		List<TechniciansModel> getAllTechie=techniciansService.getAllTechnicians();
		model.addAttribute("techies",getAllTechie);

		return "addcustomerpage";
	}
	
	
	@PostMapping("/addingnewcustomerdetails")
	public String addingNewCustomerDetails(UserDetailsModel userDetailsModel,Model model) {
		System.out.println(userDetailsModel.getUseremail()+userDetailsModel.getUsercontact());
		boolean res=userService.addNewCustomer(userDetailsModel);
		UserDetailsModel userid=userService.getSelectedUserByEmail(userDetailsModel.getUseremail());
		System.out.println("got it while saving "+userid.getUserid());
		if(res==true) {
			model.addAttribute("Userid",userid.getUserid());
			model.addAttribute("msg","data added");
		}
		else {
			model.addAttribute("msg","data not added");
		}
	
		return "addcustomerpage";
	}
	
	
	
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam("userID") int id,Model model) {
		
//		System.out.p   rintln(id);
		userService.deleteUsersByID(id);
		List<UserDetailsModel> gettingAllUsers=userService.getAllUser();
		model.addAttribute("users",gettingAllUsers);
		
		
		return "clientPannel";
	}
	
	
	
	
}
