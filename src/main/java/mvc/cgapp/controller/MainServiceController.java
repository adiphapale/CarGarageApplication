package mvc.cgapp.controller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mvc.cgapp.model.MainServicesModel;
import mvc.cgapp.model.SubServicesModel;
import mvc.cgapp.model.VehicleFormModel;

import mvc.cgapp.service.MainServicesService;
import mvc.cgapp.service.UserVehicleService;

@Controller
public class MainServiceController {

	@Autowired
	UserVehicleService userVehicleService;

	@Autowired
	MainServicesService mainServicesService;

	@RequestMapping("/servicedetailspage")
	public String serviceDetailsPage(@ModelAttribute("carDetails") VehicleFormModel vehicleFormModel, Model model) {
		List<VehicleFormModel> getAllCars = userVehicleService.getAllCars();
		model.addAttribute("vehicles", getAllCars);
		return "ServiceDetails";
	}

	
	  @GetMapping("/searchcarbynplate_servicepage")
	 
	  @ResponseBody public List<VehicleFormModel>
	  searchCarByNPlate(VehicleFormModel vehicleFormModel, Model model) {
	 
	  List<VehicleFormModel> getSelectedCars = userVehicleService
	  .getSelectedCarsByVNPlate(vehicleFormModel.getVehiclenplate());
	 model.addAttribute("vehicles", getSelectedCars);
	 
	 return getSelectedCars; }
	 

	/*
	 * @GetMapping("/getAllVehicles")
	 * 
	 * @ResponseBody public List<VehicleFormModel> getAllVehicles(VehicleFormModel
	 * vehicleFormModel) {
	 * 
	 * return userVehicleService
	 * .getSelectedCarsByVNPlate(vehicleFormModel.getVehiclenplate()); // Implement
	 * this method in your service to fetch all vehicles }
	 */


	@RequestMapping("/allocateservice")
	public String allocateServices(@RequestParam("VisitID") int vvid, Model model) {
		Map<MainServicesModel, List<SubServicesModel>> servicemap = mainServicesService.getAllServices();
		model.addAttribute("servicesMap", servicemap);
		model.addAttribute("visitID", vvid);
		return "allocateservicepage";
	}
	@RequestMapping("/submitServices")
	public String submitServices(@RequestParam("vvid") int vvid,
	                              @RequestParam(value = "selectedSubServices", required = false) List<Integer> subServiceIDs,
	                              Model model) {

	    if (subServiceIDs == null || subServiceIDs.isEmpty()) {
	        // Add an attribute to show the message in the JSP
	        model.addAttribute("message", "Please select at least one service before submitting.");
	        // Redirect to the service page
	        return "allocateservicepage";
	    }

	    boolean res = mainServicesService.linkVVIDtoSSID(vvid, subServiceIDs);
	    if (res) {
	        return "redirect:/allocatespareparts?VisitID=" + vvid;
	    }
	    return "allocateservicepage";
	}

}
