package mvc.cgapp.repository;

import mvc.cgapp.model.BillingModel;

public interface BillingRepo {

	BillingModel fetchBill(int vvid);
}
