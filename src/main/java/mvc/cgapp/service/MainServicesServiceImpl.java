package mvc.cgapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.cgapp.model.MainServicesModel;
import mvc.cgapp.model.SubServicesModel;
import mvc.cgapp.repository.MainServicesRepo;
import mvc.cgapp.repository.MainServicesRepoImpl;

@Service
public class MainServicesServiceImpl implements MainServicesService{

	@Autowired
	MainServicesRepo mainServicesRepo;
	
	

	@Override
	public List<SubServicesModel> getSubServicesByMsId(int msid) {
		
		return mainServicesRepo.getSubServicesByMsId(msid);
	}
	
	
	@Override
	public Map<MainServicesModel, List<SubServicesModel>> getAllServices() {
		
		return mainServicesRepo.getAllServices();
	}


	@Override
	public boolean linkVVIDtoSSID(int vvid, List<Integer> subServiceIDs) {
		
		return mainServicesRepo.linkVVIDtoSSID(vvid, subServiceIDs);
	}

	
}
