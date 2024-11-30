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

    // Display the spare parts page
    @RequestMapping("/sparePartspage")
    public String sparePartsPage(@ModelAttribute("vehiclesDetails") VehicleFormModel vehicleFormModel, Model model) {
        List<VehicleFormModel> getAllCars = userVehicleService.getAllCars();
        model.addAttribute("vehicles", getAllCars);
        return "sparePartsPage";
    }

    // Search cars by number plate
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

    // Display the allocate spare parts page
    @RequestMapping("/allocatespareparts")
    public String allocateSparePartsPage(@RequestParam("VisitID") int vvid, Model model) {
        Map<MainSparePartsModel, List<SubSparePartsModel>> sparePartsMap = sparePartsService.getAllSpareParts();
        model.addAttribute("mapSpareParts", sparePartsMap);
        model.addAttribute("visitID", vvid);
        return "allocatesparepartspage";
    }

    // Handle spare parts submission
    @RequestMapping("/submitSpareParts")
    public String submitSpareParts(@RequestParam Map<String, String> allParams, RedirectAttributes redirectAttributes,
            @RequestParam("vvid") int vvid) {

        // LinkedHashMap to maintain the order of selection (if necessary)
        Map<Integer, Integer> SpidQty = new LinkedHashMap<>();
        boolean anyPartSelected = false;

        // Iterate through the parameters to find selected spare parts and their quantities
        for (Map.Entry<String, String> entry : allParams.entrySet()) {
            String paramName = entry.getKey();

            if (paramName.startsWith("subCategory_")) {
                String subSparePartId = paramName.substring("subCategory_".length());
                String quantityParamName = "quantity_" + subSparePartId;
                String quantity = allParams.get(quantityParamName);

                // Only process if quantity is provided
                if (quantity != null && !quantity.trim().isEmpty()) {
                    int spid = Integer.parseInt(subSparePartId);
                    int qty = Integer.parseInt(quantity);
                    SpidQty.put(spid, qty);
                    anyPartSelected = true; // Mark that a part has been selected
                }
            }
        }

        // If no parts were selected, redirect back with an error message
        if (!anyPartSelected) {
            redirectAttributes.addFlashAttribute("message", "Please select at least one spare part.");
            return "redirect:/allocatespareparts?VisitID=" + vvid;
        }

        // If parts are selected, save the selection and redirect to billing
        boolean res = sparePartsService.linkSPID_QTY_VVID(vvid, SpidQty);
        if (res) {
            // Success: Redirect to the billing page
            redirectAttributes.addFlashAttribute("successMessage", "Spare parts allocated successfully.");
            return "redirect:/allocatebilling?VisitID=" + vvid;
        }

        // In case of an error, return to the same page with an error message
        redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while allocating spare parts.");
        return "redirect:/allocatespareparts?VisitID=" + vvid;
    }

}
