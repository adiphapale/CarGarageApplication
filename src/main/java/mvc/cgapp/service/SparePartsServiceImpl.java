package mvc.cgapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.cgapp.model.MainSparePartsModel;
import mvc.cgapp.model.SubSparePartsModel;
import mvc.cgapp.repository.SparePartsRepo;

@Service
public class SparePartsServiceImpl implements SparePartsService{

	@Autowired
	SparePartsRepo sparePartsRepo;
	@Override
	public Map<MainSparePartsModel, List<SubSparePartsModel>> getAllSpareParts() {
		
		return sparePartsRepo.getAllSpareParts();
	}
	@Override
	public boolean linkSPID_QTY_VVID(int vvid, Map<Integer, Integer> SpidQty) {
		
		return sparePartsRepo.linkSPID_QTY_VVID(vvid, SpidQty);
	}

}
