package mvc.cgapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc.cgapp.model.BillingModel;
import mvc.cgapp.model.VehicleFormModel;
import mvc.cgapp.service.BillingService;
import mvc.cgapp.service.UserVehicleService;

@Controller
public class BillingController {

	@Autowired
	UserVehicleService userVehicleService;
	
	@Autowired
	BillingService billingService;
	
	@RequestMapping("/billingPage")
	public String billingPage(@ModelAttribute("carDetails") VehicleFormModel vehicleFormModel,Model model) {
		List<VehicleFormModel> getAllCars=userVehicleService.getAllCars();
		model.addAttribute("vehicles",getAllCars);
		return "billingpage";
	}
	
	
	
	@RequestMapping("/checkVehicleNumber_bpage")
	@ResponseBody
	public List<VehicleFormModel> searchByNPlate(@RequestParam("vehiclenplate") String nplate,Model model) {
		System.out.println(nplate);
		
		
		List<VehicleFormModel> getSelectedCars=userVehicleService.getSelectedCarsByVNPlate(nplate);
		
		return getSelectedCars;
		
	}
	
	
	
	
	@PostMapping("/searchcarbynplate_billpage")
	public String searchCarByNPlate(VehicleFormModel vehicleFormModel,Model model) {
		if(vehicleFormModel.getVehiclenplate().isEmpty()) {
			List<VehicleFormModel> getAllCars=userVehicleService.getAllCars();
			model.addAttribute("vehicles",getAllCars);
		}
		else {
			List<VehicleFormModel> getSelectedCars=userVehicleService.getSelectedCarsByVNPlate(vehicleFormModel.getVehiclenplate());
			model.addAttribute("vehicles",getSelectedCars);
		}
		
		return "billingpage";
	}
	
	@RequestMapping("/allocatebilling")
	public String allocateBilling(@RequestParam("VisitID") int vvid,Model model) {
		
		
		try{
			BillingModel customerBill=billingService.fetchBill(vvid);
			model.addAttribute("billingModel",customerBill);
			return "allocatebillingpage";
		}
		catch(Exception ex) {ex.printStackTrace();
			return "redirect:/searchcarbynplate_billpage";
		}
		
		
	}

}
