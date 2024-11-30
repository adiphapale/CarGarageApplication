//package mvc.cgapp.controller;
//
//import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;   
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import mvc.cgapp.model.TechniciansModel;
//import mvc.cgapp.model.VehicleFormModel;
//import mvc.cgapp.service.TechniciansService;
//
//@Controller
//public class TechnicianController {
//
//	@Autowired
//	TechniciansService techniciansService;
//	
//	@RequestMapping("/techiepage")
//	public String techiePage(@ModelAttribute("techieDetail") TechniciansModel techniciansModel) {
//
//		return "technicianPage";
//	}
//
//	
//	
//	@RequestMapping("/checktechie")
//	@ResponseBody
//	public List<TechniciansModel> searchByTechieName(@RequestParam("techieName") String tname,Model model) {
//		System.out.println(tname);
//		
//		
//		List<TechniciansModel> getSelectedTechies=techniciansService.getSelectedTechies(tname);
//		
//		return getSelectedTechies;
//		
//	}
//	
//	
//	
//	@PostMapping("processformfortechie")
//	public String processFormforTechie(TechniciansModel techniciansModel, Model model) {
//
//		if (techniciansModel.getTname().isEmpty()) {
//
//			List<TechniciansModel> gettingTechies = techniciansService.getAllTechnicians();
//			model.addAttribute("techies", gettingTechies);
//		} else {
//			model.addAttribute("techieinfo", techniciansModel);
//
//			List<TechniciansModel> gettingSelectedTechies = techniciansService.getSelectedTechies(techniciansModel.getTname());
//			model.addAttribute("techies", gettingSelectedTechies);
//		}
//		return "technicianPage";
//	}
//
//	@PostMapping("/submitformfortechie")
//	public String submitFormforVehicle(TechniciansModel techniciansModel) {
//		
//		System.out.println("tech name:- "+techniciansModel.getTname());
//		return "redirect:/techiepage";
//	}
//	
//	@RequestMapping("/updateTechie")
//	public String UpdateTechie(@RequestParam("tID") int tid, Model model) {
//
//		System.out.println(tid);
//		// UserDetailsModel selectedUser = userService.getSelectedUsersByID(id);
////		System.out.println(selectedUser);
//		// model.addAttribute("userinfo", selectedUser);
//
//		// List<UserVehicleModel> getAllSelectedVehicles =
//		// userVehicleService.getVehiclesByUserID(id);
//
//		// model.addAttribute("vehicles", getAllSelectedVehicles);
//		return "userAddUpdate";
//	}
//	
//	@RequestMapping("/addnewTechie")
//	public String addNewTechie(@ModelAttribute("techieDetails") TechniciansModel techniciansModel) {
//		
//		return "technicianPage3";
//	}
//	
//	@RequestMapping("/addingnewtechiedetails")
//	public String addingNewTechieDetails(TechniciansModel techniciansModel) {
//		
//		return "technicianPage3";
//	}
//
//}
