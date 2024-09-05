package mvc.cgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mvc.cgapp.model.UserDetailsModel;
import mvc.cgapp.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public List<UserDetailsModel> getAllUser() {

		return userRepo.getAllUser();
	}

	@Override
	public List<UserDetailsModel> getSelectedUsers(UserDetailsModel userDetailsModel) {

		if (!userDetailsModel.getUsername().isEmpty()) {
			if (!userDetailsModel.getUsercontact().isEmpty()) {
				return userRepo.getSelectedUsersByNameContact(userDetailsModel.getUsername(),
						userDetailsModel.getUsercontact());
			}
			if (!userDetailsModel.getUseremail().isEmpty()) {
				return userRepo.getSelectedUsersByNameEmail(userDetailsModel.getUsername(),
						userDetailsModel.getUseremail());
			}
			if (!userDetailsModel.getUseraddress().isEmpty()) {
				return userRepo.getSelectedUsersByNameAddress(userDetailsModel.getUsername(),
						userDetailsModel.getUseraddress());
			}
			return userRepo.getSelectedUsersByName(userDetailsModel.getUsername());

		}
		if (!userDetailsModel.getUsercontact().isEmpty()) {
			if (!userDetailsModel.getUseremail().isEmpty()) {
				return userRepo.getSelectedUsersByContactEmail(userDetailsModel.getUsercontact(),
						userDetailsModel.getUseremail());
			}
			return userRepo.getSelectedUsersByContact(userDetailsModel.getUsercontact());
		}
		if (!userDetailsModel.getUseremail().isEmpty()) {
			return userRepo.getSelectedUsersByEmail(userDetailsModel.getUseremail());
		}
		if (!userDetailsModel.getUseraddress().isEmpty()) {
			return userRepo.getSelectedUsersByAddress(userDetailsModel.getUseraddress());
		}

		return userRepo.getAllUser();
	}

	@Override
	public UserDetailsModel getSelectedUsersByID(int userid) {

		return userRepo.getSelectedUsersByID(userid);
	}

	@Override
	public void deleteUsersByID(int userid) {

		userRepo.deleteUsersByID(userid);
	}

	@Override
	public UserDetailsModel getUpdatedUser(UserDetailsModel userDetailsModel) {

		return userRepo.getUpdatedUser(userDetailsModel);
	}

	@Override
	public boolean addNewCustomer(UserDetailsModel userDetailsModel) {
		
		return userRepo.addNewCustomer(userDetailsModel);
	}

	@Override
	public UserDetailsModel getSelectedUserByEmail(String email) {

		return userRepo.getSelectedUserByEmail(email);
	}

	@Override
	public UserDetailsModel getSelectedUsersByVisitID(int vvid) {
		
		return userRepo.getSelectedUsersByVisitID(vvid);
	}

}
