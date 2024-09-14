package mvc.cgapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.cgapp.model.CustomerLoginModel;
import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.repository.CustomerLoginRepo;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{
	
	@Autowired
	CustomerLoginRepo customerLoginRepo;

	@Override
	public UserDetailsModel isCustomerLogoin(CustomerLoginModel customerLoginModel) {
		
		return customerLoginRepo.isCustomerLogoin(customerLoginModel);
	}
}
