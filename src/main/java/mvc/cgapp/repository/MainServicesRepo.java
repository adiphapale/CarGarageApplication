package mvc.cgapp.repository;

import java.util.List;

import mvc.cgapp.model.MainServicesModel;
import mvc.cgapp.model.SubServicesModel;

public interface MainServicesRepo {

	List<MainServicesModel> getAllMainServices();
	
	List<SubServicesModel> getSubServicesByMsId(int msid);
}
