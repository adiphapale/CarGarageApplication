package mvc.cgapp.service;

import java.util.List;

import mvc.cgapp.model.MainServicesModel;
import mvc.cgapp.model.SubServicesModel;

public interface MainServicesService {

	List<MainServicesModel> getAllMainServices();
	
	List<SubServicesModel> getSubServicesByMsId(int msid);
}
