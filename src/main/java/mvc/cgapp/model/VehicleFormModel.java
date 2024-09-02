package mvc.cgapp.model;

public class VehicleFormModel {

	private int vehicleid;
	private String vehiclemodel;
	private String vehiclenplate;
	private long visitVrun;
	private String visitVentryDate;
	private int tid;
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
	public long getVisitVrun() {
		return visitVrun;
	}
	public void setVisitVrun(long visitVrun) {
		this.visitVrun = visitVrun;
	}
	public String getVisitVentryDate() {
		return visitVentryDate;
	}
	public void setVisitVentryDate(String visitVentryDate) {
		this.visitVentryDate = visitVentryDate;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "VehicleFormModel [vehicleid=" + vehicleid + ", vehiclemodel=" + vehiclemodel + ", vehiclenplate="
				+ vehiclenplate + ", visitVrun=" + visitVrun + ", visitVentryDate=" + visitVentryDate + ", tid=" + tid
				+ "]";
	}

	
}
