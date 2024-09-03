package mvc.cgapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.cgapp.model.TechniciansModel;
import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.service.TechniciansService;

@Controller
public class TechnicianController {

	@Autowired
	TechniciansService techniciansService;
	
	@RequestMapping("/techiepage")
	public String techiePage(@ModelAttribute("techieDetail") TechniciansModel techniciansModel) {

		return "technicianPage";
	}

	@PostMapping("processformfortechie")
	public String processFormforTechie(TechniciansModel techniciansModel, Model model) {

		if (techniciansModel.getTname().isEmpty()) {

			List<TechniciansModel> gettingTechies = techniciansService.getAllTechnicians();
			model.addAttribute("techies", gettingTechies);
		} else {
			model.addAttribute("techieinfo", techniciansModel);

			List<TechniciansModel> gettingSelectedTechies = techniciansService.getSelectedTechies(techniciansModel.getTname());
			model.addAttribute("techies", gettingSelectedTechies);
		}
		return "technicianPage";
	}

	@PostMapping("/submitformfortechie")
	public String submitFormforVehicle(TechniciansModel techniciansModel) {
		
		System.out.println("tech name:- "+techniciansModel.getTname());
		return "redirect:/techiepage";
	}
	
	@RequestMapping("/updateTechie")
	public String UpdateTechie(@RequestParam("tID") int tid, Model model) {

		System.out.println(tid);
		// UserDetailsModel selectedUser = userService.getSelectedUsersByID(id);
//		System.out.println(selectedUser);
		// model.addAttribute("userinfo", selectedUser);

		// List<UserVehicleModel> getAllSelectedVehicles =
		// userVehicleService.getVehiclesByUserID(id);

		// model.addAttribute("vehicles", getAllSelectedVehicles);
		return "userAddUpdate";
	}

	@RequestMapping("/deleteTechie")
	public String deleteTechie(@RequestParam("tID") int tid, Model model) {

		System.out.println(tid);
		// userService.deleteUsersByID(id);
		// List<UserDetailsModel> gettingAllUsers = userService.getAllUser();
		// model.addAttribute("users", gettingAllUsers);

		return "clientPannel";
	}
}
