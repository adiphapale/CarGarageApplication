package mvc.cgapp.model;

public class CommonVDetailsModel {
	
	private UserVehicleModel uservehicleModel;
	private VisitVehicleModel visitVehicleModel;
	private TechniciansModel techniciansModel;
	
	public UserVehicleModel getUservehicleModel() {
		return uservehicleModel;
	}
	public void setUservehicleModel(UserVehicleModel uservehicleModel) {
		this.uservehicleModel = uservehicleModel;
	}
	public VisitVehicleModel getVisitVehicleModel() {
		return visitVehicleModel;
	}
	public void setVisitVehicleModel(VisitVehicleModel visitVehicleModel) {
		this.visitVehicleModel = visitVehicleModel;
	}
	public TechniciansModel getTechniciansModel() {
		return techniciansModel;
	}
	public void setTechniciansModel(TechniciansModel techniciansModel) {
		this.techniciansModel = techniciansModel;
	}
	@Override
	public String toString() {
		return "CommonVDetailsModel [uservehicleModel=" + uservehicleModel + ", visitVehicleModel=" + visitVehicleModel
				+ ", techniciansModel=" + techniciansModel + "]";
	}

}
