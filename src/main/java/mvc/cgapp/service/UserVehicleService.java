package mvc.cgapp.service;

import java.util.List;

import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.model.UserVehicleModel;

public interface UserVehicleService {

	List<UserVehicleModel> getVehiclesByUserID(int vid);
	
	List<UserVehicleModel> getAllCars();
	
	List<UserVehicleModel> getSelectedCars(UserVehicleModel userVehicleModel);
	
	UserVehicleModel getSelectedCarssByID(int vid);
	
}
