package mvc.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.cgapp.model.VehicleFormModel;
import mvc.cgapp.service.UserVehicleService;

@Controller
public class ReportController {
	
	@Autowired
	UserVehicleService userVehicleService;
	
	@RequestMapping("/reportPage")
	public String reprtPage(@ModelAttribute("carDetailss") VehicleFormModel vehicleFormModel) {

		return "reportPage";
	}
	
	@PostMapping("/searchcarbynplate_reportpage")
	public String searchCarByNPlate(VehicleFormModel vehicleFormModel,Model model) {
		if(vehicleFormModel.getVehiclenplate().isEmpty()) {
			List<VehicleFormModel> getAllCars=userVehicleService.getAllCars();
			model.addAttribute("vehicles",getAllCars);
		}
		else {
			List<VehicleFormModel> getSelectedCars=userVehicleService.getSelectedCarsByVNPlate(vehicleFormModel.getVehiclenplate());
			model.addAttribute("vehicles",getSelectedCars);
		}
		
		return "reportPage";
	}

}
