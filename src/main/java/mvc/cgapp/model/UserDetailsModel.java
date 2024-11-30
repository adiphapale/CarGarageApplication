package mvc.cgapp.model;

public class UserDetailsModel {

	private int userid;
	private String username;
	private String usercontact;
	private String useremail;
	private String useraddress;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsercontact() {
		return usercontact;
	}
	public void setUsercontact(String usercontact) {
		this.usercontact = usercontact;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	@Override
	public String toString() {
		return "UserDetailsModel [userid=" + userid + ", username=" + username + ", usercontact=" + usercontact
				+ ", useremail=" + useremail + ", useraddress=" + useraddress + "]";
	}
	
}
