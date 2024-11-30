package mvc.cgapp.repository;

import mvc.cgapp.model.CustomerLoginModel;
import mvc.cgapp.model.UserDetailsModel;

public interface CustomerLoginRepo {
	public UserDetailsModel isCustomerLogoin(CustomerLoginModel customerLoginModel);
}
