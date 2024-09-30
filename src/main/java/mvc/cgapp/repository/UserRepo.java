package mvc.cgapp.repository;

import java.util.List;

import mvc.cgapp.model.UserDetailsModel;

public interface UserRepo {

	List<UserDetailsModel> getAllUser();
	
	List<UserDetailsModel> getSelectedUsersByName(String uname);
	List<UserDetailsModel> getSelectedUsersByNameContact(String uname,String contact);
	List<UserDetailsModel> getSelectedUsersByNameEmail(String uname,String email);
	List<UserDetailsModel> getSelectedUsersByNameAddress(String uname,String address);
	/*---------------------------------------------------------------------------------*/
	List<UserDetailsModel> getSelectedUsersByContact(String contact);
	List<UserDetailsModel> getSelectedUsersByContactEmail(String contact,String email);
	List<UserDetailsModel> getSelectedUsersByContactAddress(String contact,String address);
	/*---------------------------------------------------------------------------------*/
	
	List<UserDetailsModel> getSelectedUsersByEmail(String email);
	List<UserDetailsModel> getSelectedUsersByEmailAddress(String email,String address);
	/*---------------------------------------------------------------------------------*/
	
	List<UserDetailsModel> getSelectedUsersByAddress(String address);

	UserDetailsModel getSelectedUsersByID(int userid);
	
	boolean deleteUsersByID(int userid);
	
	UserDetailsModel getUpdatedUser(UserDetailsModel userDetailsModel);
	
	public boolean addNewCustomer(UserDetailsModel userDetailsModel);
	
	public UserDetailsModel getSelectedUserByEmail(String email);
	
	
	UserDetailsModel getSelectedUsersByVisitID(int vvid);
	
	int getUIDByEmail(String email);
	
//this is for later inserted user	
	UserDetailsModel addFirstVehiclendUser(UserDetailsModel userDetailsModel);

}
