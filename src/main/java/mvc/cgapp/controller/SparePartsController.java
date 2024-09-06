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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mvc.cgapp.model.MainSparePartsModel;
import mvc.cgapp.model.SubSparePartsModel;
import mvc.cgapp.model.VehicleFormModel;
import mvc.cgapp.service.SparePartsService;
import mvc.cgapp.service.UserVehicleService;

@Controller
public class SparePartsController {

	@Autowired
	SparePartsService sparePartsService;

	@Autowired
	UserVehicleService userVehicleService;

	@RequestMapping("/sparePartspage")
	public String sparePartsPage(@ModelAttribute("vehiclesDetails") VehicleFormModel vehicleFormModel) {

		return "sparePartsPage";
	}

	@PostMapping("/searchcarbynplate_sparepartpage")
	public String searchCarByNPlate(VehicleFormModel vehicleFormModel, Model model) {
		if (vehicleFormModel.getVehiclenplate().isEmpty()) {
			List<VehicleFormModel> getAllCars = userVehicleService.getAllCars();
			model.addAttribute("vehicles", getAllCars);
		} else {
			List<VehicleFormModel> getSelectedCars = userVehicleService
					.getSelectedCarsByVNPlate(vehicleFormModel.getVehiclenplate());
			model.addAttribute("vehicles", getSelectedCars);
		}

		return "sparePartsPage";
	}

	@RequestMapping("/allocatespareparts")
	public String allocateSparePartsPage(@RequestParam("VisitID") int vvid, Model model) {
		Map<MainSparePartsModel, List<SubSparePartsModel>> sparePartsMap = sparePartsService.getAllSpareParts();
		model.addAttribute("mapSpareParts", sparePartsMap);
		model.addAttribute("visitID", vvid);
		return "allocatesparepartspage";
	}

	@RequestMapping("/submitSpareParts")
	public String submitSpareParts(@RequestParam Map<String, String> allParams, RedirectAttributes redirectAttributes,
			@RequestParam("vvid") int vvid) {

		System.out.println(vvid);
		// Iterate through all parameters
		Map<Integer, Integer> SpidQty = new LinkedHashMap<Integer, Integer>();
		for (Map.Entry<String, String> entry : allParams.entrySet()) {
			String paramName = entry.getKey();

			if (paramName.startsWith("subCategory_")) {
				String subSparePartId = paramName.substring("subCategory_".length());
				// Get the quantity for this subSparePartId
				String quantityParamName = "quantity_" + subSparePartId;
				String quantity = allParams.get(quantityParamName);

				int spid = Integer.parseInt(subSparePartId);
				int qty = Integer.parseInt(quantity);
				SpidQty.put(spid, qty);

				// Process the subSparePartId and quantity here
				System.out.println("SubSparePart ID: " + subSparePartId + ", Quantity: " + quantity);
			}
		}

		System.out.println(SpidQty);
		boolean res = sparePartsService.linkSPID_QTY_VVID(vvid, SpidQty);
		if(res==true) {
			return "redirect:/allocatebilling?VisitID="+vvid;
		}
		return "allocatesparepartspage"; // Adjust the redirect path as needed
	}

}
