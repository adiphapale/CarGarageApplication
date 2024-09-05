package mvc.cgapp.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.cgapp.model.MainServicesModel;
import mvc.cgapp.model.SubServicesModel;
import mvc.cgapp.model.VehicleFormModel;
import mvc.cgapp.repository.MainServicesRepo;
import mvc.cgapp.service.MainServicesService;
import mvc.cgapp.service.UserVehicleService;

@Controller
public class MainServiceController {

	@Autowired
	UserVehicleService userVehicleService;
	
	@Autowired
	MainServicesService mainServicesService;
	
	@RequestMapping("/servicedetailspage")
	public String serviceDetailsPage(@ModelAttribute("carDetails") VehicleFormModel vehicleFormModel) {
		
		return "ServiceDetails";
	}
	
	@PostMapping("/searchcarbynplate")
	public String searchCarByNPlate(VehicleFormModel vehicleFormModel,Model model) {
		if(vehicleFormModel.getVehiclenplate().isEmpty()) {
			List<VehicleFormModel> getAllCars=userVehicleService.getAllCars();
			model.addAttribute("vehicles",getAllCars);
		}
		else {
			List<VehicleFormModel> getSelectedCars=userVehicleService.getSelectedCarsByVNPlate(vehicleFormModel.getVehiclenplate());
			model.addAttribute("vehicles",getSelectedCars);
		}
		
		return "ServiceDetails";
	}
	
	@RequestMapping("/allocateservice")
	public String allocateServices(@RequestParam("VisitID") int vvid,Model model) {		
		Map<MainServicesModel,List<SubServicesModel>> servicemap=mainServicesService.getAllServices();
		model.addAttribute("servicesMap",servicemap);
		model.addAttribute("visitID",vvid);
		return "allocateservicepage";
	}
	
	@RequestMapping("/submitServices")
	public String submitServices(@RequestParam("vvid") int vvid,@RequestParam("selectedSubServices") List<Integer> subServiceIDs,Model model) {
		
		boolean res=mainServicesService.linkVVIDtoSSID(vvid,subServiceIDs);
		if(res==true)
		System.out.println("vvid and ssid linked");
		return "allocateservicepage";
	}
}
