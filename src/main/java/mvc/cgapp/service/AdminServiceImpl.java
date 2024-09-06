package mvc.cgapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.cgapp.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepo adminRepo;
	
	@Override
	public boolean checkValidAdmin(String adminName, String pass) {
		
		return adminRepo.checkValidAdmin(adminName, pass);
	}

}
