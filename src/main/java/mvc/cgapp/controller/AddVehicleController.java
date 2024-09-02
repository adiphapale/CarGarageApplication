package mvc.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.cgapp.model.TechniciansModel;
import mvc.cgapp.model.UserVehicleModel;
import mvc.cgapp.service.TechniciansService;
import mvc.cgapp.service.TechniciansServiceImpl;

@Controller
public class AddVehicleController {
	
	
	
	@RequestMapping("/vehicleform")
	public String newVehicle(@ModelAttribute("userVehicleModel") UserVehicleModel userVehicleModel) {
	
		return "NewVehicle";
	}
	
	

}
