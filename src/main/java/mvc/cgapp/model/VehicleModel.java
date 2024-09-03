package mvc.cgapp.model;

public class VehicleModel {
	private int vid;
	private String vehiclemodel;
	private String vehicleplate;
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVehiclemodel() {
		return vehiclemodel;
	}
	public void setVehiclemodel(String vehiclemodel) {
		this.vehiclemodel = vehiclemodel;
	}
	public String getVehicleplate() {
		return vehicleplate;
	}
	public void setVehicleplate(String vehicleplate) {
		this.vehicleplate = vehicleplate;
	}
	@Override
	public String toString() {
		return "VehicleModel [vid=" + vid + ", vehiclemodel=" + vehiclemodel + ", vehicleplate=" + vehicleplate + "]";
	}
	
}
