package mvc.cgapp.service;

import java.util.List;

import mvc.cgapp.model.UserDetailsModel;

public interface UserService {

	List<UserDetailsModel> getAllUser();
	
	List<UserDetailsModel> getSelectedUsers(UserDetailsModel userDetailsModel);
	
	UserDetailsModel getSelectedUsersByID(int userid);
	
	void deleteUsersByID(int userid);
	
	UserDetailsModel getUpdatedUser(UserDetailsModel userDetailsModel);

	public boolean addNewCustomer(UserDetailsModel userDetailsModel);
	
	UserDetailsModel getSelectedUserByEmail(String email);
	
	UserDetailsModel getSelectedUsersByVisitID(int vvid);
}
