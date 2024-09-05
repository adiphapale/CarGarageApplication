package mvc.cgapp.controller;

import java.util.List;

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
import mvc.cgapp.model.TechniciansModel;
import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.model.UserVehicleModel;
import mvc.cgapp.service.MainServicesService;
import mvc.cgapp.service.TechniciansService;

@Controller
public class AddCustVehicle {

	@Autowired
	TechniciansService techniciansService;
	
	@Autowired
	MainServicesService mainServicesService;
	
	@RequestMapping("/newcustvehicle")
	public String newCustVehicle() {
		
		return "newCustVehicle";
	}
	
	
	@RequestMapping("/custvehicleform")
	public String custVehicleForm(Model model) {
	    model.addAttribute("userDetailsModel", new UserDetailsModel());
	    model.addAttribute("userVehicleModel", new UserVehicleModel());
	    List<TechniciansModel> getAllTechie=techniciansService.getAllTechnicians();
//	    List<MainServicesModel> gettingAllMainServices=mainServicesService.getAllMainServices();
	    model.addAttribute("techies",getAllTechie);
//		model.addAttribute("mainServices",gettingAllMainServices);
		
	    return "custVehicleForm";
	}
	
	
	@GetMapping("/getSubServices")
	@ResponseBody
	public List<SubServicesModel> getSubServices(@RequestParam("msid") int msid) {
	    System.out.println("main service id is:- "+msid);
		
		// Fetch the sub-services based on the main service ID
	    List<SubServicesModel> getSub=mainServicesService.getSubServicesByMsId(msid);
	    System.out.println(getSub);
	    return getSub;
		
	}
	
	@PostMapping("/acceptcustvehicleform")
	public String acceptCustVehicleForm(@ModelAttribute("userDetailsModel") UserDetailsModel userDetailsModel, 
	                                    @ModelAttribute("userVehicleModel") UserVehicleModel userVehicleModel) {
	    System.out.println(userDetailsModel);
	    System.out.println(userVehicleModel);
	    return "custVehicleForm";
	}

}
