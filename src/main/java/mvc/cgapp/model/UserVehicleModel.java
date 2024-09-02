package mvc.cgapp.model;

public class UserVehicleModel {

	private int vehicleid;
	private String vehiclemodel;
	private String vehiclenplate;
	private int userid;
	public int getVehicleid() {
		return vehicleid;
	}
	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}
	public String getVehiclemodel() {
		return vehiclemodel;
	}
	public void setVehiclemodel(String vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}
	public String getVehiclenplate() {
		return vehiclenplate;
	}
	public void setVehiclenplate(String vehiclenplate) {
		this.vehiclenplate = vehiclenplate;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "UserVehicleModel [vehicleid=" + vehicleid + ", vehiclemodel=" + vehiclemodel + ", vehiclenplate="
				+ vehiclenplate + ", userid=" + userid + "]";
	}
}
