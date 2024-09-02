package mvc.cgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.cgapp.model.UserVehicleModel;
import mvc.cgapp.repository.UserVehicleRepo;

@Service
public class UserVehicleServiceImpl implements UserVehicleService {

	@Autowired
	UserVehicleRepo userVehicleRepo;
	
	@Override
	public List<UserVehicleModel> getVehiclesByUserID(int userid) {
		
		return userVehicleRepo.getVehiclesByUserID(userid);
	}

	@Override
	public List<UserVehicleModel> getAllCars() {
		
		return userVehicleRepo.getAllCars();
	}

	@Override
	public List<UserVehicleModel> getSelectedCars(UserVehicleModel userVehicleModel) {
		/*
		 * if (!userVehicleModel.getVehiclemodel().isEmpty()) { if
		 * (!userVehicleModel.getVehiclenplate().isEmpty()) { return
		 * userVehicleRepo.getSelectedCarsByModelNumberPlate(userVehicleModel.
		 * getVehiclemodel(), userVehicleModel.getVehiclenplate()); } if
		 * (!(userVehicleModel.getVehiclerun()==null)) { return
		 * userVehicleRepo.getSelectedCarsByModelKm(userVehicleModel.getVehiclemodel(),
		 * userVehicleModel.getVehiclerun()); } if
		 * (!userVehicleModel.getVehicledate().isEmpty()) { return
		 * userVehicleRepo.getSelectedCarsByModelEntryDate(userVehicleModel.
		 * getVehiclemodel(), userVehicleModel.getVehicledate()); } return
		 * userVehicleRepo.getSelectedCarsByModel(userVehicleModel.getVehiclemodel());
		 * 
		 * } if (!userVehicleModel.getVehiclenplate().isEmpty()) { if
		 * (!(userVehicleModel.getVehiclerun()==null)) { return
		 * userVehicleRepo.getSelectedCarsByNumberPlateKm(userVehicleModel.
		 * getVehiclenplate(), userVehicleModel.getVehiclerun()); } return
		 * userVehicleRepo.getSelectedCarsByNumberPlate(userVehicleModel.
		 * getVehiclenplate()); } if (!(userVehicleModel.getVehiclerun()==null)) {
		 * return userVehicleRepo.getSelectedCarsByKm(userVehicleModel.getVehiclerun());
		 * } if (!userVehicleModel.getVehicledate().isEmpty()) { return
		 * userVehicleRepo.getSelectedCarsByEntryDate(userVehicleModel.getVehicledate())
		 * ; }
		 */
		return userVehicleRepo.getAllCars();
	}

	@Override
	public UserVehicleModel getSelectedCarssByID(int vid) {
		
		return userVehicleRepo.getSelectedCarsByID(vid);
	}

}
