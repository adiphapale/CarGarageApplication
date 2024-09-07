package mvc.cgapp.service;

import java.util.List;
import java.util.Map;
import mvc.cgapp.model.MainSparePartsModel;
import mvc.cgapp.model.SubSparePartsModel;

public interface SparePartsService {

	Map<MainSparePartsModel,List<SubSparePartsModel>> getAllSpareParts();
	
	boolean linkSPID_QTY_VVID(int vvid,Map<Integer,Integer> SpidQty);
}
