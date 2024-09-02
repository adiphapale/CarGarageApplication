package mvc.cgapp.repository;

import java.util.List;

import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.model.UserVehicleModel;

public interface UserVehicleRepo {

	List<UserVehicleModel> getVehiclesByUserID(int userid);
	
	List<UserVehicleModel> getAllCars();
	
	List<UserVehicleModel> getSelectedCarsByModel(String vmodel);
	List<UserVehicleModel> getSelectedCarsByModelNumberPlate(String vmodel,String vnplate);
	List<UserVehicleModel> getSelectedCarsByModelKm(String vmodel,Long vrun);
	List<UserVehicleModel> getSelectedCarsByModelEntryDate(String vmodel,String vdate);
	/*---------------------------------------------------------------------------------*/
	List<UserVehicleModel> getSelectedCarsByNumberPlate(String vnplate);
	List<UserVehicleModel> getSelectedCarsByNumberPlateKm(String vnplate,Long vrun);
	List<UserVehicleModel> getSelectedCarsByNumberPlateEntryDate(String vnplate,String vdate);
	/*---------------------------------------------------------------------------------*/
	
	List<UserVehicleModel> getSelectedCarsByKm(Long vrun);
	List<UserVehicleModel> getSelectedCarsByKmEntryDate(Long vrun,String vdate);
	/*---------------------------------------------------------------------------------*/
	
	List<UserVehicleModel> getSelectedCarsByEntryDate(String vdate);

	UserVehicleModel getSelectedCarsByID(int vid);
	
//	void deleteUsersByID(int userid);
}
