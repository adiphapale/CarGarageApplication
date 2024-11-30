package mvc.cgapp.model;

public class UserVehicleModel {

	private int vehicleid;
	private String vehiclemodel;
	private String vehiclenplate;
	private Long userid;
	
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
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "UserVehicleModel [vehicleid=" + vehicleid + ", vehiclemodel=" + vehiclemodel + ", vehiclenplate="
				+ vehiclenplate + ", userid=" + userid + "]";
	}
}
