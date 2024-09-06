package mvc.cgapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.cgapp.model.BillingModel;
import mvc.cgapp.repository.BillingRepo;

@Service
public class BillingServiceImpl implements BillingService{

	@Autowired
	BillingRepo billingRepo;

	@Override
	public BillingModel fetchBill(int vvid) {
		
		return billingRepo.fetchBill(vvid);
	}
}
