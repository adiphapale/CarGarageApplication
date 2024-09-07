package mvc.cgapp.repository;

import java.util.List;
import java.util.Map;
import mvc.cgapp.model.MainSparePartsModel;
import mvc.cgapp.model.SubSparePartsModel;

public interface SparePartsRepo {
	
	Map<MainSparePartsModel,List<SubSparePartsModel>> getAllSpareParts();
	
	List<SubSparePartsModel> getSubSparePartsByMSPID(int mspid);
	
	boolean linkSPID_QTY_VVID(int vvid,Map<Integer,Integer> SpidQty);
}
