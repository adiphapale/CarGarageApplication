package mvc.cgapp.service;

import mvc.cgapp.model.UserVehicleModel;
import mvc.cgapp.model.VehicleFormModel;
import mvc.cgapp.model.VisitVehicleModel;

public interface CarHandleService {
	
	boolean addVehicleAndVisitVehicleDetails(VehicleFormModel vehicleFormModel,Long userID);
	
	
	boolean deleteVehicleByVVID(int vvid);
//	public boolean addVehicleDataProcess(VehicleFormModel vehicleFormModel,Long userid);
//	public int saveVehicleData(UserVehicleModel userVehicleModel);
//	public int saveVisitVehicleData(VisitVehicleModel visitVehicleModel);
//	
	VehicleFormModel getUpdatedVehicle(VehicleFormModel vehicleFormModel);
}
