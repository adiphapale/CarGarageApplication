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
import mvc.cgapp.model.TechniciansModel;
import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.model.UserVehicleModel;
import mvc.cgapp.model.VehicleFormModel;
import mvc.cgapp.model.VisitVehicleModel;
import mvc.cgapp.service.CarHandleService;
import mvc.cgapp.service.TechniciansService;
import mvc.cgapp.service.UserService;
import mvc.cgapp.service.UserVehicleService;

@Controller
public class CarHandleController {

	@Autowired
	CarHandleService carHandleService;

	@Autowired
	UserVehicleService userVehicleService;

	@Autowired
	UserService userService;

	@Autowired
	TechniciansService techniciansService;

	@RequestMapping("/cardetails")
	public String carDetails(@ModelAttribute("carDetails") VehicleFormModel vehicleFormModel, Model model) {
		List<TechniciansModel> getalltechies = techniciansService.getAllTechnicians();
		model.addAttribute("techies", getalltechies);
		return "CarDetails";
	}

	@PostMapping("searchcar")
	public String searchCar(VehicleFormModel vehicleFormModel, Model model) {

		List<TechniciansModel> getalltechies = techniciansService.getAllTechnicians();

		model.addAttribute("techies", getalltechies);
		
		if (vehicleFormModel.getVehiclemodel().isEmpty() && vehicleFormModel.getVehiclenplate().isEmpty()
				&& vehicleFormModel.getVisitVentryDate().isEmpty() && vehicleFormModel.getTname() == null) {
			List<VehicleFormModel> gettingAllCars = userVehicleService.getAllCars();
			model.addAttribute("vehicles", gettingAllCars);
		} else {
			List<VehicleFormModel> gettingSelectedCars = userVehicleService.getSelectedCars(vehicleFormModel);
			System.out.println(vehicleFormModel);
			System.out.println(gettingSelectedCars);
			model.addAttribute("carinfo", vehicleFormModel);
			model.addAttribute("vehicles", gettingSelectedCars);
		}

		return "CarDetails";
	}

	@PostMapping("/submitformforvehicle")
	public String processFormForCar(VehicleFormModel vehicleFormModel, @RequestParam("UserIDCustomer") String userid,
			Model model) {

		Long userID = null;
		try {
			userID = Long.parseLong(userid);
			if (userID == 0) {
				userID = null;
			}

		} catch (Exception ex) {
		}
		System.out.println("details got it");
		System.out.println(vehicleFormModel);
		carHandleService.addVehicleDataProcess(vehicleFormModel, userID);
		int uid = userID.intValue();
		UserDetailsModel selectedUser = userService.getSelectedUsersByID(uid);
		List<VehicleFormModel> getAllSelectedVehicles = userVehicleService.getVehiclesByUserID(uid);
		List<TechniciansModel> getalltechies = techniciansService.getAllTechnicians();

		model.addAttribute("userinfo", selectedUser);
		model.addAttribute("vehicles", getAllSelectedVehicles);
		model.addAttribute("techies", getalltechies);
		return "userAddUpdate";
	}
	
	@RequestMapping("/addnewvehicle")
	public String addnewvehicle(@ModelAttribute("VehicleDetails")VehicleFormModel vehicleFormModel ,Model model) {
		List<TechniciansModel> getalltechies = techniciansService.getAllTechnicians();

		
		model.addAttribute("techies", getalltechies);
		
		
		return "addvehiclepage";
	}
	
	@PostMapping("/addingnewcardetails")
	public String addingNewCardetails(VehicleFormModel vehicleFormModel,Model model) {
		
		boolean res=carHandleService.addVehicleDataProcess(vehicleFormModel, null);
		
		
		if(res==true) {
			VehicleFormModel vehicle=userVehicleService.getSelectedCarByEntryDate(vehicleFormModel.getVisitVentryDate());
			model.addAttribute("vehicle",vehicle);
			model.addAttribute("msg","data added");
		}
		else {
			model.addAttribute("msg","data not added");
		}
		return "addvehiclepage";
	}
	
	@RequestMapping("/updateforcar")
	public String updateForCar(@RequestParam("VisitID") int vvid,Model model) {
		
		System.out.println("visit id for car :- "+vvid);
		
		VehicleFormModel vehicleFormModel=userVehicleService.getSelectedCarByID(vvid);
		UserDetailsModel selectedUser=userService.getSelectedUsersByVisitID(vvid);
		
		model.addAttribute("customer",selectedUser);
		model.addAttribute("carinfo",vehicleFormModel);
		
		return "carupdatepage";
	}

}
