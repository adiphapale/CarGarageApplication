package mvc.cgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.model.UserVehicleModel;
import mvc.cgapp.model.VehicleFormModel;
import mvc.cgapp.repository.UserRepo;
import mvc.cgapp.repository.UserVehicleRepo;

@Service
public class UserVehicleServiceImpl implements UserVehicleService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserVehicleRepo userVehicleRepo;

	@Override
	public List<VehicleFormModel> getVehiclesByUserID(int userid) {

		return userVehicleRepo.getVehiclesByUserID(userid);
	}

	@Override
	public List<VehicleFormModel> getAllCars() {

		return userVehicleRepo.getAllCars();
	}

	@Override
	public List<VehicleFormModel> getSelectedCars(VehicleFormModel vehicleFormModel) {

		String vmodel = vehicleFormModel.getVehiclemodel();
		String vnplate = vehicleFormModel.getVehiclenplate();
		String vventryDate = vehicleFormModel.getVisitVentryDate();
		String tname = vehicleFormModel.getTname();
		System.out.println(vehicleFormModel);
		
		
		if (!(vmodel.isEmpty())) {
			System.out.println("model is +"+ vmodel );
			if (!vnplate.isEmpty()) {
				System.out.println(" vmodel and vnplate ");
				return userVehicleRepo.getSelectedCarsByModelNumberPlate(vmodel,
						vnplate);
			}
			if (!vventryDate.isEmpty()) {
				System.out.println(" vmodel and vventrydate ");
				return userVehicleRepo.getSelectedCarsByModelEntryDate(vmodel,
						vventryDate);
			}
			if(!(tname.isEmpty()))
			{
				System.out.println(" vmodel and tname ");
				return userVehicleRepo.getSelectedCarsByModelTname(vmodel, tname);
			}
			
			return userVehicleRepo.getSelectedCarsByModel(vmodel);

		}
		
		
		if (!(vnplate.isEmpty())) {
			System.out.println("vnplate is "+vnplate);
			if(!vventryDate.isEmpty()) {
				System.out.println("vnplate and date");
				return userVehicleRepo.getSelectedCarsByNumberPlateEntryDate(vnplate, vventryDate);
			}
			if(!(tname.isEmpty())) {
				System.out.println("vnplate and tname");
				return userVehicleRepo.getSelectedCarsByNumberPlateTname(vnplate, tname);
			}
			return userVehicleRepo.getSelectedCarsByNumberPlate(vnplate);
		}
		
		
		if(!(vventryDate.isEmpty())) {
			System.out.println("entry data getted");
			if(!(tname.isEmpty())) {
				System.out.println("edata and tname");
				return userVehicleRepo.getSelectedCarsByEntryDateTname(vventryDate,tname);
			}
			return userVehicleRepo.getSelectedCarsByEntryDate(vventryDate);
			
		}
		
		if(!(tname.isEmpty())) {
			System.out.println("tech availb");
			return userVehicleRepo.getSelectedCarsByTname(tname);
		}

		return getAllCars();
	}

	@Override
	public VehicleFormModel getSelectedCarByID(int vvid) {

		return userVehicleRepo.getSelectedCarByID(vvid);
	}

	@Override
	public VehicleFormModel getSelectedCarByEntryDate(String vnDate) {
		
		return userVehicleRepo.getSelectedCarByEntryDate(vnDate);
	}

	
	@Override
	public void linkVIDCustomer(UserDetailsModel userDetailsModel) {
		int vid=userVehicleRepo.gettingVID(userDetailsModel.getUserid());
		int uid=userRepo.getUIDByEmail(userDetailsModel.getUseremail());
		boolean res=userVehicleRepo.getLinkedUIDinVehicle(vid,uid);
		if(res!=false) {
			System.out.println("vid and uid data linked.....");
		}
	}

	@Override
	public List<VehicleFormModel> getSelectedCarsByVNPlate(String vnplate) {
		
		return userVehicleRepo.getSelectedCarsByNumberPlate(vnplate);
	}

	@Override
	public boolean checkIfVehicleExists(String vehicleNumber) {
		
		return userVehicleRepo.checkIfVehicleExists(vehicleNumber);
	}

}
