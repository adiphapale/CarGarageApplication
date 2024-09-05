package mvc.cgapp.service;

import org.springframework.stereotype.Service;

import mvc.cgapp.model.CustomerLoginModel;
import mvc.cgapp.repository.CustomerLoginRepo;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService{
	CustomerLoginRepo customerLoginRepo;

	@Override
	public boolean isCustomerLogoin(CustomerLoginModel customerLoginModel) {
		
		return customerLoginRepo.isCustomerLogoin(customerLoginModel);
	}
}
