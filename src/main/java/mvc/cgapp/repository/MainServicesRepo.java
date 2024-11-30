package mvc.cgapp.repository;

import java.util.List;
import java.util.Map;

import mvc.cgapp.model.MainServicesModel;
import mvc.cgapp.model.SubServicesModel;

public interface MainServicesRepo {

	Map<MainServicesModel,List<SubServicesModel>> getAllServices();
	
	List<SubServicesModel> getSubServicesByMsId(int msid);
	
	boolean linkVVIDtoSSID(int vvid,List<Integer> subServiceIDs);
}