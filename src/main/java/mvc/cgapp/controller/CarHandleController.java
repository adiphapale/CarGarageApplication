package mvc.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.cgapp.model.CommonVDetailsModel;
import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.model.UserVehicleModel;
import mvc.cgapp.model.VehicleFormModel;
import mvc.cgapp.model.VisitVehicleModel;
import mvc.cgapp.service.UserService;
import mvc.cgapp.service.UserVehicleService;

@Controller
public class CarHandleController {

	
	@Autowired
	UserVehicleService userVehicleService;
	
	@RequestMapping("/cardetails")
	public String carDetails(@ModelAttribute("carDetails") UserVehicleModel userVehicleModel) {
		
		
		return "CarDetails";
	}
	
	@PostMapping("/submitformforvehicle")
	public String processFormForCar(VehicleFormModel vehicleFormModel,@RequestParam("UserIDCustomer") String userid) {

		int userID=0;
		try{
			userID=Integer.parseInt(userid);
		}catch(Exception ex) {}
		System.out.println("details got it");
		System.out.println(vehicleFormModel);

		return "CarDetails";
	}
	

}
