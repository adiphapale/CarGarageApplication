package mvc.cgapp.repository;

import mvc.cgapp.model.UserVehicleModel;
import mvc.cgapp.model.VehicleFormModel;
import mvc.cgapp.model.VisitVehicleModel;

public interface CarHandleRepo {
	
	
	boolean addVehicleAndVisitVehicleDetails(VehicleFormModel vehicleFormModel,Long userID);
	
	
	boolean deleteVehicleByVVID(int vvid);
	

	public int saveVehicleData(UserVehicleModel userVehicleModel);
	
	public int getVehicleId(String vnplate);
	
	public boolean addVehicleData(VehicleFormModel vehicleFormModel);
	
	public int saveVisitVehicleData(VisitVehicleModel visitVehicleModel);

	public int getVisitVehicleId(String vvEntryDate);
	
	VehicleFormModel getUpdatedVehicle(VehicleFormModel vehicleFormModel);
}
