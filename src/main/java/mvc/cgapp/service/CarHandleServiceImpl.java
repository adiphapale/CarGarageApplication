package mvc.cgapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.cgapp.model.UserVehicleModel;
import mvc.cgapp.model.VehicleFormModel;
import mvc.cgapp.model.VisitVehicleModel;
import mvc.cgapp.repository.CarHandleRepo;

@Service
public class CarHandleServiceImpl implements CarHandleService{

	@Autowired
	CarHandleRepo carHandleRepo;
	
	@Override
	public boolean addVehicleDataProcess(VehicleFormModel vehicleFormModel,Long userid) {

		UserVehicleModel userVehicleModel=new UserVehicleModel();
		userVehicleModel.setVehiclemodel(vehicleFormModel.getVehiclemodel());
		userVehicleModel.setVehiclenplate(vehicleFormModel.getVehiclenplate());
		userVehicleModel.setUserid(userid);
		
		//show userVehicleModel details
		System.out.println(userVehicleModel);
		
		int vid=saveVehicleData(userVehicleModel);
		System.out.println("vid : "+vid);
		VisitVehicleModel visitVehicleModel=new VisitVehicleModel();
		visitVehicleModel.setVisitVrun(vehicleFormModel.getVisitVrun());
		visitVehicleModel.setVisitVentryDate(vehicleFormModel.getVisitVentryDate());
		visitVehicleModel.setVid(vid);
		visitVehicleModel.setTid(vehicleFormModel.getTid());

		int vvid=saveVisitVehicleData(visitVehicleModel);
		System.out.println("vvid : "+vvid);
		
		
		return carHandleRepo.addVehicleData(vehicleFormModel);
	}
	
	@Override
	public int saveVehicleData(UserVehicleModel userVehicleModel) {
		
		return carHandleRepo.saveVehicleData(userVehicleModel);
	}

	@Override
	public int saveVisitVehicleData(VisitVehicleModel visitVehicleModel) {
		
		return carHandleRepo.saveVisitVehicleData(visitVehicleModel);
	}

	
	



	
	

}
